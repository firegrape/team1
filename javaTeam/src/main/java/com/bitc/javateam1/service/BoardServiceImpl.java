package com.bitc.javateam1.service;

import com.bitc.javateam1.dto.BoardDTO;
import com.bitc.javateam1.mapper.BoardMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;


    @Override
    public Page<BoardDTO> selectPageList(int pageNum)throws Exception {

        PageHelper.startPage(pageNum, 3);
        return boardMapper.selectPageList();
    }


    @Override
    public BoardDTO selectBoardDetail(int cmIdx) throws Exception{
        return boardMapper.selectBoardDetail(cmIdx);
    }

    @Override
    public void deleteBoard(int cmIdx)throws Exception {
        boardMapper.deleteBoard(cmIdx);

    }

    @Override
    public void updateBoard(BoardDTO board)throws Exception{
        boardMapper.updateBoard(board);

    }

    @Override
    public void insertBoard(BoardDTO board)throws Exception {
        boardMapper.insertBoard(board);
    }

}
