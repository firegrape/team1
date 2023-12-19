package com.bitc.javateam1.service;

import com.bitc.javateam1.dto.MemberDTO;
import com.bitc.javateam1.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memberMapper;
	@Override
	public void Register(MemberDTO memberDTO) throws Exception{

		memberMapper.Register(memberDTO);
	}
	@Override
	public int isUserInfo(String id, String password) throws Exception {
		return memberMapper.isUserInfo(id, password);
	}

	@Override
	public MemberDTO getUserInfo(String id) throws Exception {
		return memberMapper.getUserInfo(id);
	}

	@Override
	public int regiCheck(MemberDTO memberDTO)throws Exception {
		return memberMapper.regiCheck(memberDTO);
	}


}
