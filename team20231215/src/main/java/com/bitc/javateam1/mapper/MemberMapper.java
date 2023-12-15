package com.bitc.javateam1.mapper;


import com.bitc.javateam1.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {
	public void Register(MemberDTO memberDTO)throws Exception;

	int isUserInfo(@Param("id") String id, @Param("password") String password) throws Exception;

	MemberDTO getUserInfo(@Param("id") String id) throws  Exception;
}
