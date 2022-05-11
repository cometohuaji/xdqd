package com.example.demo.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.example.demo.Entity.*;

@Mapper
public interface UserMapper {
    //查询，可以实现登录功能
    @Select("SELECT * FROM user_tb WHERE userName = #{userName} AND password = #{password}")
    UserBean getInfo(@Param("userName") String userName, @Param("password") String password);

    //多个参数要加@Param修饰
    //增加，可以实现注册功能
    @Insert("insert into user_tb(userName,password)values(#{userName},#{password})")
    void saveInfo(@Param("userName") String userName, @Param("password") String password);
}
