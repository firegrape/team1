package com.bitc.javateam1.service;

import com.bitc.javateam1.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    public List<BoardDTO> selectBoardList() throws Exception;

    BoardDTO selectBoardDetail(int cmIdx);

    void deleteBoard(int cmIdx);

    void updateBoard(BoardDTO board);

    void insertBoard(BoardDTO board);
}
