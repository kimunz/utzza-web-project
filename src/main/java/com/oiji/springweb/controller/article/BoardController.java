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
    public String getBoardViewPage(@RequestParam int id, @ModelAttribute Criteria criteria, @AuthenticationPrincipal UserEntity user, Model model) {

        Board board = boardService.getBoardById(criteria, id);
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
}
