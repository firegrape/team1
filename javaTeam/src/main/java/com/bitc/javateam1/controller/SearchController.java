package com.bitc.javateam1.controller;

import com.bitc.javateam1.dto.ParkDTO;
import com.bitc.javateam1.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/search")
@Controller
public class SearchController {
    @Autowired
    ParkService parkService;


    @RequestMapping("/search")
public String SearchView()throws Exception{

        return "search/search";
}



@GetMapping("/getSearchList")
    @ResponseBody
    public List<ParkDTO>getSearchList(@RequestParam("type")String type, @RequestParam("keyword")String keyword)throws Exception{
        ParkDTO parkDTO = new ParkDTO();
        parkDTO.setType(type);
        parkDTO.setKeyword(keyword);

    List<ParkDTO> result = parkService.getSearchList(parkDTO);

    System.out.println(result);
 return result;
}
}
