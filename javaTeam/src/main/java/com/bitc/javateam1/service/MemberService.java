package com.bitc.javateam1.service;

import com.bitc.javateam1.dto.MemberDTO;

public interface MemberService {
 public void register(MemberDTO memberDTO) throws Exception;

 public int isUserInfo(String id, String password) throws Exception;

public MemberDTO getUserInfo(String id) throws Exception;
}
