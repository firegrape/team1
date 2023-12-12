package com.bitc.javateam1.mapper;


import com.bitc.javateam1.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {
	public void register(MemberDTO memberDTO)throws Exception;

	int isUserInfo(@Param("id") String userId, @Param("password") String userPw) throws Exception;

	MemberDTO getUserInfo(@Param("id") String userId) throws  Exception;
}
