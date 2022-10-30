package com.lijianhua.mybatisplus;

import com.lijianhua.mybatisplus.entity.Product;
import com.lijianhua.mybatisplus.entity.User;
import com.lijianhua.mybatisplus.service.IProductService;
import com.lijianhua.mybatisplus.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlusDatasourceApplicationTests {

    @Autowired
    private IUserService userService;

    @Autowired
    private IProductService productService;

    @Test
    public void test() {
        //查询master库的t_user表
        List<User> users =
                userService.list();
        users.forEach(System.out::println);
        //查询slave_1库的product表
        List<Product> products = productService.list();
        products.forEach(System.out::println);
        /*  日志信息：可以看出使用了两个sqlSession
        Creating a new SqlSession
        SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@2272cbb0] was not registered for synchronization because synchronization is not active
        JDBC Connection [HikariProxyConnection@1699637904 wrapping com.mysql.cj.jdbc.ConnectionImpl@14168e1] will not be managed by Spring
        ==>  Preparing: SELECT uid,user_name,age,email,sex,is_deleted FROM t_user WHERE is_deleted=0
        ==> Parameters:
        <==    Columns: uid, user_name, age, email, sex, is_deleted
        <==        Row: 1, Jone, 18, test1@baomidou.com, null, 0
        <==        Row: 2, Jack, 20, test2@baomidou.com, null, 0
        <==        Row: 3, Tom, 28, test3@baomidou.com, null, 0
        <==        Row: 4, Sandy, 21, test4@baomidou.com, null, 0
        <==        Row: 5, Billie, 24, test5@baomidou.com, null, 0
        <==        Row: 999, 李四, 999, lisi@qq.com, null, 0
        <==        Row: 1000, 张飞, 18, 1976288368@qq.com, null, 0
        <==        Row: 1001, admin, 33, null, 1, 0
        <==      Total: 8
        Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@2272cbb0]
        User{uid = 1, userName = Jone, age = 18, email = test1@baomidou.com, sex = null, isDeleted = 0}
        User{uid = 2, userName = Jack, age = 20, email = test2@baomidou.com, sex = null, isDeleted = 0}
        User{uid = 3, userName = Tom, age = 28, email = test3@baomidou.com, sex = null, isDeleted = 0}
        User{uid = 4, userName = Sandy, age = 21, email = test4@baomidou.com, sex = null, isDeleted = 0}
        User{uid = 5, userName = Billie, age = 24, email = test5@baomidou.com, sex = null, isDeleted = 0}
        User{uid = 999, userName = 李四, age = 999, email = lisi@qq.com, sex = null, isDeleted = 0}
        User{uid = 1000, userName = 张飞, age = 18, email = 1976288368@qq.com, sex = null, isDeleted = 0}
        User{uid = 1001, userName = admin, age = 33, email = null, sex = 1, isDeleted = 0}
        Creating a new SqlSession
        SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@7a9ceddf] was not registered for synchronization because synchronization is not active
        JDBC Connection [HikariProxyConnection@672493939 wrapping com.mysql.cj.jdbc.ConnectionImpl@11c713b7] will not be managed by Spring
        ==>  Preparing: SELECT id,name,price,version FROM product
        ==> Parameters:
        <==    Columns: id, name, price, version
        <==        Row: 1, 外星人笔记本, 100, 0
        <==      Total: 1
        Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@7a9ceddf]
        Product{id = 1, name = 外星人笔记本, price = 100, version = 0}
         */
    }


}
