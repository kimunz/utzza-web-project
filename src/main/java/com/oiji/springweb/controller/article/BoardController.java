package com.oiji.springweb.controller.article;

import com.oiji.springweb.dto.article.Board;
import com.oiji.springweb.entity.UserEntity;
import com.oiji.springweb.paging.Criteria;
import com.oiji.springweb.paging.PaginationInfo;
import com.oiji.springweb.service.article.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board")
    public String getBoardListPage(@ModelAttribute Criteria criteria, Model model) {

        List<Board> list = boardService.getBoardList(criteria);
        int count = boardService.getBoardCount(criteria);

        model.addAttribute("list", list);
        model.addAttribute("pageMaker", new PaginationInfo(criteria, count, 5));
        return "board/list";
    }

    @GetMapping("/board/view")
    public String getBoardViewPage(@RequestParam int id, @ModelAttribute Criteria criteria,
                                   HttpServletRequest request, HttpServletResponse response,
                                   @AuthenticationPrincipal UserEntity user, Model model) {

        Board board = boardService.getBoardById(criteria, id);

        Cookie oldCookie = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cookie"+id)) {
                    oldCookie = cookie;
                }
            }
        }
        if(oldCookie == null) {
            Cookie newCookie = new Cookie("cookie"+id, "[" + id + "]");
            response.addCookie(newCookie);
            boardService.updateBoardHit(id);
        }

        model.addAttribute("board", board);
        model.addAttribute("user", user);

        return "board/view";
    }

    @GetMapping("/board/write")
    public String writeBoardForm(@AuthenticationPrincipal UserEntity user, Model model) {

        model.addAttribute("user", user);
        return "board/write";
    }

    @PostMapping("/board/write")
    public String writeBoard(@ModelAttribute Board board) {

        boardService.addBoard(board);
        return "redirect:/board";
    }

    @GetMapping("/board/edit")
    public String editBoardForm(@RequestParam int id,
                                @ModelAttribute Criteria criteria,
                                @AuthenticationPrincipal UserEntity user,
                                Model model) {

        Board board = boardService.getBoardById(criteria, id);
        if (user == null || !user.getName().equals(board.getWriterId())) {
            return "message/auth";
        }
        board.setContent(board.getContent().replace("<br>", "\r\n"));
        model.addAttribute("board", board);
        return "board/edit";
    }

    @PostMapping("/board/edit")
    public String editBoard(@ModelAttribute Board board) {
        boardService.editBoard(board);
        return "redirect:/board";
    }

    @PostMapping("/board/remove")
    public String removeBoard(@RequestParam int id,
                              @RequestParam String writerId,
                              @AuthenticationPrincipal UserEntity user) {

        if (user == null || !user.getName().equals(writerId)) {
            return "message/auth";
        }
        boardService.removeBoard(id);
        return "redirect:/board";
    }
}
