package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.MessageConstant;
import com.example.common.PageParam;
import com.example.common.R;
import com.example.common.StatusConstant;
import com.example.entity.Users;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDateTime;

/**
 * @author 86186
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/page")
    public R<Page> pageInfo(@RequestParam(required = false, defaultValue = "1") int page,
                            @RequestParam(required = false, defaultValue = "10") int pageSize,
                            @RequestParam(required = false) String userName,
                            @RequestParam(required = false) String id,
                            @RequestParam(required = false) String phone,
                            @RequestParam(required = false) Integer status,
                            @RequestParam(required = false) String idNumber) {
        PageParam pageParam = new PageParam();
        pageParam.setPage(page);
        pageParam.setPageSize(pageSize);
        pageParam.setId(id);
        pageParam.setStatus(status);
        pageParam.setPhone(phone);
        pageParam.setUserName(userName);
        pageParam.setIdNumber(idNumber);
        return userService.pageWithConditions(pageParam);
    }


    @PostMapping("/login")
    public R<Users> login(@RequestBody Users user) {
        boolean login = userService.login(user);
        if (login) return R.success(user);
        else return R.error(MessageConstant.LOGIN_FAUILURE);

    }

    @PostMapping("/save")
    public R<String> save(@RequestBody Users user){
        userService.saveUser(user);
        return R.success(MessageConstant.SAVE_SUCCESS);
    }


    @PostMapping("/add")
    public R<String> add(@RequestBody Users user) {
        userService.addNew(user);
        return R.success(MessageConstant.ADD_SUCCESS);
    }

    @DeleteMapping("/{id}")
    public R<String> delete(Long id) {
        userService.deleteUser(id);
        return R.success(MessageConstant.DELETE_SUCCESS);
    }


}
