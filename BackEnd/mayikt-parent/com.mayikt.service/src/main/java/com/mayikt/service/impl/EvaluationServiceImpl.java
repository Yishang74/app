package com.mayikt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mayikt.entity.Evaluation;
import com.mayikt.mapper.EvaluationMapper;
import com.mayikt.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class EvaluationServiceImpl extends ServiceImpl<EvaluationMapper, Evaluation> implements EvaluationService {

    @Autowired
    private EvaluationMapper mapper;

    @Override
    public List<Evaluation> findAllByClassId(Integer classId) {
        return mapper.findAllByClassId(classId);
    }
}
