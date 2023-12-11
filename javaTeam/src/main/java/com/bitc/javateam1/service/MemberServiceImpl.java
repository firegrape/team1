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
	public void register(MemberDTO memberDTO) throws Exception{



		memberMapper.register(memberDTO);
	}
}
