package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.example.entity.*;
@Mapper
public interface UserMapper extends BaseMapper<Users> {

}
