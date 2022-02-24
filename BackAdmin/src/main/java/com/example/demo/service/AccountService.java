package com.example.demo.service;

import com.example.demo.bean.t_f;
import com.example.demo.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2022/1/26 12:32
 */
@Service
public class AccountService {

    @Autowired
    AccountMapper accountMapper;

    public t_f getid(int id){
      return accountMapper.gettf(id);
    }
}
