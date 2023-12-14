package com.bitc.javateam1.controller;

import com.bitc.javateam1.dto.MemberDTO;
import com.bitc.javateam1.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;

@Controller
@RequestMapping("/login")
public class LoginController {
@Autowired
	MemberService memberService;
	//    회원가입
	@RequestMapping("/register")
	public String join()  {
		return "/login/register";
	}


//로그인

	@RequestMapping("/login.do")
	public String login() throws Exception {
		return "login/login";
	}

	@RequestMapping(value = "/LoginProcess", method = RequestMethod.POST)
	public String loginProcess(@RequestParam("id") String id, @RequestParam("password") String password, HttpServletRequest req) throws Exception {

		int result = memberService.isUserInfo(id, password);

		if (result == 1) {
			MemberDTO user = memberService.getUserInfo(id);

			HttpSession session = req.getSession();
			session.setAttribute("id", user.getId());
			session.setAttribute("nickName", user.getNickName());
			session.setAttribute("password", user.getPassword());
			session.setMaxInactiveInterval(60*60*1); //세션 유지 시간 설정

			return "redirect:/main/minsome";
		}
		else {

			return "redirect:/login/login.do?errorMsg=" + URLEncoder.encode("로그인 정보가 다릅니다.", "UTF-8");
		}
	}

	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest req) throws Exception{
		HttpSession session = req.getSession();

		session.removeAttribute("id");
		session.removeAttribute("nickName");
		session.removeAttribute("password");

		session.invalidate();

		return "redirect:/hello1";
	}

}
