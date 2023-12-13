package com.bitc.javateam1.service;

import com.bitc.javateam1.dto.BoardDTO;
import com.bitc.javateam1.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;
    @Override
    public List<BoardDTO> selectBoardList() throws Exception {
        return  boardMapper.selectBoardList();
    }

    @Override
    public BoardDTO selectBoardDetail(int cmIdx) {
        return boardMapper.selectBoardDetail(cmIdx);
    }

    @Override
    public void deleteBoard(int cmIdx) {
        boardMapper.deleteBoard(cmIdx);

    }

    @Override
    public void updateBoard(BoardDTO board) {
        boardMapper.updateBoard(board);

    }

    @Override
    public void insertBoard(BoardDTO board) {
        boardMapper.insertBoard(board);
    }

}
