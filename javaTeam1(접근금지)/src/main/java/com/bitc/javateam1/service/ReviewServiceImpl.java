package com.bitc.javateam1.service;

import com.bitc.javateam1.dto.ReviewDTO;
import com.bitc.javateam1.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewMapper reviewMapper;
    @Override
    public void InsertView(ReviewDTO review)throws Exception {
        reviewMapper.InsertReview(review);
    }

    @Override
    public List<ReviewDTO> SelectReview(int commIdx) throws Exception {
        return reviewMapper.SelectReview(commIdx);
    }
}
