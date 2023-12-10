package com.bitc.javateam1.mapper;

import com.bitc.javateam1.dto.ParkDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ParkMapper {
    public ParkDTO selectParkList()throws Exception;
}
