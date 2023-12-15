package com.bitc.javateam1.controller;

import com.bitc.javateam1.dto.BoardDTO;
import com.bitc.javateam1.dto.ParkDTO;
import com.bitc.javateam1.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class BoardController {

    @Autowired
    private BoardService boardService;

    //글 목록
    @RequestMapping(value = "board", method = RequestMethod.GET)
    public ModelAndView boardList() throws Exception {
        ModelAndView mv = new ModelAndView("board/shotboard/shotBoardList");

        List<BoardDTO> boardList = boardService.selectBoardList();
        mv.addObject("boardList", boardList);

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

    //글 입력 폼
    @GetMapping("board/insert")
    public String boardInsertView() throws Exception {
        return "board/shotboard/shotBoardInsert";
    }

    //글 입력
    @PostMapping("board/insert")
    public String boardInsertProcess(BoardDTO board) throws Exception {
        boardService.insertBoard(board);

        return "redirect:/board";
    }

    @RequestMapping("/board/updateBoard.do")
    public String updateBoard(BoardDTO board) throws Exception {
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
