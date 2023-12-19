package com.bitc.javateam1.controller;

import com.bitc.javateam1.dto.BoardDTO;
import com.bitc.javateam1.dto.ParkDTO;
import com.bitc.javateam1.service.BoardService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class BoardController {

    @Autowired
    private BoardService boardService;

    //글 목록
    @GetMapping("board")
    public ModelAndView selectBoardPagingList(@RequestParam(required = false, defaultValue = "1", value = "pageNum") int pageNum) throws Exception {
        ModelAndView mv = new ModelAndView("board/shotboard/shotBoardList");

        PageInfo<BoardDTO> PageList = new PageInfo<>(boardService.selectPageList(pageNum), 5);

        mv.addObject("PageList", PageList);

        return mv;
    }

    //글 상세
    @GetMapping("board/{cmIdx}")
    public ModelAndView boardDetail(@PathVariable("cmIdx") int cmIdx) throws Exception {
        ModelAndView mv = new ModelAndView("board/shotboard/shotBoardDetail");

        BoardDTO board = boardService.selectBoardDetail(cmIdx);
        mv.addObject("board", board);

        return mv;
    }


    //메이트게시판 목록
    @GetMapping("mate")
    public ModelAndView selectMatePagingList(@RequestParam(required = false, defaultValue = "1", value = "pageNum") int pageNum) throws Exception {
        ModelAndView mv = new ModelAndView("board/mateBoard/mateBoardList");

        PageInfo<BoardDTO> PageList = new PageInfo<>(boardService.mateList(pageNum), 5);

        mv.addObject("PageList", PageList);

        return mv;
    }

    //글 입력 폼
    @GetMapping("board/insert")
    public String boardInsertView() throws Exception {
        return "board/shotboard/shotBoardInsert";
    }

    //글 입력
    @PostMapping("board/insert")
    public String boardInsertProcess(BoardDTO board,  MultipartHttpServletRequest multipart) throws Exception {

        boardService.insertBoard(board, multipart);

        return "redirect:/board";
    }

    //글 수정 폼
    @GetMapping("board/update/{cmIdx}")
    public ModelAndView selectBoardUpdate(@PathVariable("cmIdx") int cmIdx) throws Exception {
        ModelAndView mv = new ModelAndView("board/shotboard/shotBoardUpdate");

        BoardDTO board = boardService.selectBoardDetail(cmIdx);
        mv.addObject("board", board);

        return mv;
    }

    @PostMapping("board/update")
    public String boardUpdateProcess(BoardDTO board) throws Exception {

        boardService.updateBoard(board);

        return "redirect:/board";
    }


    //  게시글 삭제하기
    @RequestMapping("/board/deleteBoard.do")
    public String deleteBoard(@RequestParam("cmIdx") int cmIdx) throws Exception {
        boardService.deleteBoard(cmIdx);

        return "redirect:/board";
    }


}
