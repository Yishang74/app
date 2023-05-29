package com.mayikt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mayikt.entity.Weekday;
import com.mayikt.mapper.WeekdayMapper;
import com.mayikt.service.WeekdayService;
import org.springframework.stereotype.Service;

@Service
public class WeekdayServiceImpl extends ServiceImpl<WeekdayMapper, Weekday> implements WeekdayService {
}
