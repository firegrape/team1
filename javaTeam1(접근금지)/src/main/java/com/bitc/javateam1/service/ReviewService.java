package com.bitc.javateam1.service;

import com.bitc.javateam1.dto.ReviewDTO;

import java.util.List;

public interface ReviewService {
    void InsertView(ReviewDTO review)throws Exception;

    List<ReviewDTO> SelectReview(int commIdx)throws Exception;
}
