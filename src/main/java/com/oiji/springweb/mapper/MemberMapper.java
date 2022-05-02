package com.oiji.springweb.mapper;

import com.oiji.springweb.dto.user.User;
import com.oiji.springweb.entity.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface MemberMapper {

    @Select("SELECT * FROM MEMBER WHERE USERID = #{loginId}")
    Optional<UserEntity> findByLoginId(String loginId);

    @Insert("INSERT INTO MEMBER VALUES(#{user.loginId},#{user.password},#{user.email},#{user.})")
    void save(User user);

}
