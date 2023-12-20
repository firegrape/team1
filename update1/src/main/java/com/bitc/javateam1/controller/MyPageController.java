package com.bitc.javateam1.controller;

import com.bitc.javateam1.Utils.JSFunction;
import com.bitc.javateam1.dto.MemberDTO;
import com.bitc.javateam1.service.BoardService;
import com.bitc.javateam1.service.MemberService;
import com.bitc.javateam1.service.ReviewService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/mypage")
public class MyPageController {
    @Autowired
    ReviewService reviewService;
    @Autowired
    BoardService boardService;

    @Autowired
    MemberService memberService;

    @RequestMapping("/mypage")
    public String MypageMain()throws Exception{


        return "mypage/mypage";
    }

    @RequestMapping("/about")
    public ModelAndView MypageAbout(HttpServletRequest req)throws Exception{
        ModelAndView mv = new ModelAndView("mypage/about");
        HttpSession session = req.getSession();
        String nickName = (String) session.getAttribute("nickName");

        MemberDTO member = memberService.myPageInform(nickName);
        mv.addObject("member", member);
        System.out.println(member);


        return mv;
    }

    @RequestMapping("/delete")
    public String MyPageDelete()throws Exception{
        return "mypage/delete";
    }

    @RequestMapping("/deleteProcess")
    public void memeberOut(HttpServletRequest request, HttpServletResponse res)throws Exception{
        HttpSession session = request.getSession();
        String nick = (String) session.getAttribute("nickName");

            reviewService.DeleteNick(nick);
            boardService.MemberDelImg(nick);
            boardService.MemberDelComm(nick);
            memberService.memberDel(nick);

        session.removeAttribute("id");
        session.removeAttribute("nickName");
        session.removeAttribute("password");

        session.invalidate();

        JSFunction.alertLocation("회원탈퇴가 완료되었습니다.","/main/minsome", res);
    }
}
