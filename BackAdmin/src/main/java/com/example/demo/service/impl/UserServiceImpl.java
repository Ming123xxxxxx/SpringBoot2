package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.bean.UsInfo;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2022/1/27 15:47
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,UsInfo> implements UserService {
}
