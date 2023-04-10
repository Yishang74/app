package com.mayikt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author bruce
 * @since 2022-12-12
 */
public class Evaluation implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "evaluation_id", type = IdType.AUTO)
    private Integer evaluationId;

    private LocalDateTime evaluationDate;


    public Integer getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(Integer evaluationId) {
        this.evaluationId = evaluationId;
    }

    public LocalDateTime getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(LocalDateTime evaluationDate) {
        this.evaluationDate = evaluationDate;
    }

    @Override
    public String toString() {
        return "Evaluation{" +
        "evaluationId=" + evaluationId +
        ", evaluationDate=" + evaluationDate +
        "}";
    }
}
