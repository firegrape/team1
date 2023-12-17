package com.bitc.javateam1.mapper;

import com.bitc.javateam1.dto.BoardDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    //public List<BoardDTO> selectBoardList() throws Exception;

    BoardDTO selectBoardDetail(int cmIdx)throws Exception;

    void insertBoard(BoardDTO board)throws Exception;

    void updateBoard(BoardDTO board)throws Exception;

    void deleteBoard(int cmIdx)throws Exception;

    Page<BoardDTO> selectPageList()throws Exception;

    Page<BoardDTO> postList(int pageNum, String cmId)throws Exception;

    public void insertBoardFileList(List<BoardDTO> fileList) throws Exception;
}
