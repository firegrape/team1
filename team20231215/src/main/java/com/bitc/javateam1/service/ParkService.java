package com.bitc.javateam1.service;

import com.bitc.javateam1.dto.ParkDTO;

import java.util.List;

public interface ParkService {
   public ParkDTO selectParkList()throws Exception;

    List<ParkDTO> getSearchList(ParkDTO parkDTO)throws Exception;
}
