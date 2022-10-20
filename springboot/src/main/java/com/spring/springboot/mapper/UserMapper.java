package com.spring.springboot.mapper;

import com.spring.springboot.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;

public interface UserMapper {

    /**
     *
     * @param user 用户的数据
     * @return 受到影响的行数
     */
    Integer insert(User user);

    /**
     *
     * @param username
     * @return 一个用户类
     */
    User findByName(String username);


    /**
     *
     * @param username
     * @return 受影响的行数
     */
    Integer delete(String username);

    /**
     *
     * @return 所有用户的信息
     */
    User[] selectAll();


    Integer changePw(@Param("password") String password, @Param("name") String name);

    /**尝试模糊匹配
     *
     */
    User[] findINSTR(String info);
}
