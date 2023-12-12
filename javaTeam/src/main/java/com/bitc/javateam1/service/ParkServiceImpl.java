package com.bitc.javateam1.service;

import com.bitc.javateam1.dto.ParkDTO;
import com.bitc.javateam1.mapper.ParkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkServiceImpl implements ParkService {

    @Autowired
    private ParkMapper parkMapper;
    @Override
    public ParkDTO selectParkList() throws Exception {
        return parkMapper.selectParkList();
    }

    @Override
    public List<ParkDTO> getSearchList(ParkDTO parkDTO) throws Exception {
        return parkMapper.getSearchList(parkDTO);
    }
}
