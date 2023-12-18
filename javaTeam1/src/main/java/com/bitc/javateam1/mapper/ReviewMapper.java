package com.bitc.javateam1.mapper;

import com.bitc.javateam1.dto.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {

    public void InsertReview(ReviewDTO review)throws Exception;

    List<ReviewDTO> SelectReview(int commIdx)throws Exception;
}
