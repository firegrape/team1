package com.bitc.javateam1.service;

import com.bitc.javateam1.dto.ParkDTO;
import com.bitc.javateam1.mapper.ParkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkServiceImpl implements ParkService {

    @Autowired
    private ParkMapper parkMapper;
    @Override
    public ParkDTO selectParkList() throws Exception {
        return parkMapper.selectParkList();
    }
}
