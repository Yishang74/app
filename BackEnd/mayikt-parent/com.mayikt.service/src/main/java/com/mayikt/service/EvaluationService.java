package com.mayikt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mayikt.entity.Evaluation;

import java.util.List;

public interface EvaluationService extends IService<Evaluation> {

    List<Evaluation> findAllByClassId(Integer classId);
}
