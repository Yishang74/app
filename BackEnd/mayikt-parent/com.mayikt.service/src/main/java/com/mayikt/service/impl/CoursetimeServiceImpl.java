package com.mayikt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mayikt.entity.Coursetime;
import com.mayikt.mapper.CoursetimeMapper;
import com.mayikt.service.CoursetimeService;
import org.springframework.stereotype.Service;

@Service
public class CoursetimeServiceImpl extends ServiceImpl<CoursetimeMapper, Coursetime> implements CoursetimeService {
}
