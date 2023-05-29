package com.mayikt.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.mayikt.entity.Evaluation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author bruce
 * @since 2022-12-05
 */
@Mapper
public interface EvaluationMapper extends BaseMapper<Evaluation> {

    @Select("select * from evaluation where object_id = #{object_id} and type = 's'")
    List<Evaluation> findAllByClassId(Integer classId);
}
