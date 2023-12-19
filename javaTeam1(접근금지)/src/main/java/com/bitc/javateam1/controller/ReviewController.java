package com.bitc.javateam1.controller;


import com.bitc.javateam1.dto.ReviewDTO;
import com.bitc.javateam1.service.ReviewService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class ReviewController {

    @Autowired
    ReviewService reviewService;


    @ResponseBody
    @PostMapping ("/review")
    public boolean ReviewInsert(@RequestParam("cmIdx")int cmIdx, @RequestParam("content") String content, HttpServletRequest req)throws Exception{

        HttpSession session = req.getSession();
        ReviewDTO review = new ReviewDTO();

        review.setCommIdx(cmIdx);
        review.setContent(content);
        review.setReNick((String) session.getAttribute("nickName"));
        reviewService.InsertView(review);


        return true;
    }

    @ResponseBody
    @PostMapping("/reviewSelect")
    public Object SelectReview(@RequestParam("commIdx")int commIdx)throws Exception{
        List<ReviewDTO> review = reviewService.SelectReview(commIdx);
        return review;
    }

}
