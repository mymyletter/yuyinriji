package com.example.yuyinriji.mapper;
import com.example.yuyinriji.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface UserMapper {
    @Insert("INSERT INTO user (username, password) VALUES(#{username}, #{password})")
    int insert(User user);
    @Select("SELECT * FROM user WHERE username = #{username}")
    User selectByUsername(String username);
}