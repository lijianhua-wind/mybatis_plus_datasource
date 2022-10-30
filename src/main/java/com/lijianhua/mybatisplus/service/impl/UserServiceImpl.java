package com.lijianhua.mybatisplus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.lijianhua.mybatisplus.entity.User;
import com.lijianhua.mybatisplus.mapper.UserMapper;
import com.lijianhua.mybatisplus.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lijianhua
 * @since 2022-10-29
 */
@DS("master") //指定操作的数据源
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
