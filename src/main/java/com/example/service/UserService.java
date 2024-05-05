package com.example.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.PageParam;
import com.example.common.R;
import com.example.entity.Users;
import org.apache.tomcat.jni.User;

public interface UserService extends IService<Users> {

     boolean login(Users user);

     boolean deleteUser(Long id);

     boolean addNew(Users user);

     boolean saveUser(Users user);

     R<Page> pageWithConditions(PageParam pageParam);

}
