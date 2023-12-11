package com.bitc.javateam1.controller;

import com.bitc.javateam1.dto.MemberDTO;
import com.bitc.javateam1.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

@PostMapping("/registerProcess")
	public String joinProcess(MemberDTO memberDTO) throws Exception{


			memberService.register(memberDTO);

		return "redirect:/park/parkMain";
}

}
