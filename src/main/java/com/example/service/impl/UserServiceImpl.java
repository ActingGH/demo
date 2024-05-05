package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.PageParam;
import com.example.common.R;
import com.example.common.StatusConstant;
import com.example.entity.Users;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.apache.tomcat.jni.User;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, Users> implements UserService {
    @Override
    public boolean login(Users user) {
        String password = user.getPassword();
        Long id = user.getId();
        Users temp = this.getById(id);
        if (temp == null) {
            return false;
        }
        if (!password.equals(temp.getPassword())) {
            return false;
        }

        if (user.getStatus() == StatusConstant.DISABLE) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteUser(Long id) {
        Users user = this.getById(id);
        user.setStatus(StatusConstant.DISABLE);
        this.updateById(user);
        return true;
    }


    @Override
    public boolean addNew(Users user) {
        user.setCreateTime(LocalDateTime.now());
        user.setStatus(StatusConstant.ENABLE);
        //若出现异常会被handler捕获
        this.save(user);
        return true;
    }

    @Override
    public boolean saveUser(Users user) {
        this.updateById(user);
        return true;
    }

    @Override
    public R<Page> pageWithConditions(PageParam pageParam) {
        Page<Users> pageinfo = new Page<>(pageParam.getPage(), pageParam.getPageSize());
        LambdaQueryWrapper<Users> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(pageParam.getUserName() != null, Users::getUsername, pageParam.getUserName())
                .like(pageParam.getId() != null, Users::getId, pageParam.getId())
                .like(pageParam.getPhone() != null, Users::getPhone, pageParam.getPhone())
                .like(pageParam.getIdNumber() != null, Users::getIdNumber, pageParam.getIdNumber())
                .eq(pageParam.getStatus() != null, Users::getStatus, pageParam.getStatus())
                .orderByDesc(Users::getCreateTime);
        this.page(pageinfo, queryWrapper);
        return R.success(pageinfo);
    }


}
