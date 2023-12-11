package com.bitc.javateam1.mapper;

import com.bitc.javateam1.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    public List<BoardDTO> selectBoardList() throws Exception;

    BoardDTO selectBoardDetail(int cmIdx);

    void insertBoard(BoardDTO board);

    void updateBoard(BoardDTO board);

    void deleteBoard(int cmIdx);
}
