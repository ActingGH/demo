package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Type;
import com.example.mapper.TypeMapper;
import com.example.service.TypeService;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService {
}
