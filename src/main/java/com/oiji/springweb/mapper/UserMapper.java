package com.oiji.springweb.mapper;

import com.oiji.springweb.dto.user.User;
import com.oiji.springweb.entity.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM MEMBER WHERE LOGINID = #{username}")
    Optional<UserEntity> findByLoginId(String username);

    @Select("SELECT * FROM MEMBER WHERE NAME = #{name}")
    Optional<UserEntity> findByName(String name);

    @Insert("INSERT INTO MEMBER VALUES(#{user.loginId},#{user.password},#{user.email},#{user.name},#{user.auth})")
    void save(@Param("user")User user);

    void modifyInfo(User user);
}
