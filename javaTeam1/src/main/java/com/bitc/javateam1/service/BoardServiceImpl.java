package com.bitc.javateam1.service;

import com.bitc.javateam1.common.FileUtils;
import com.bitc.javateam1.dto.BoardDTO;
import com.bitc.javateam1.mapper.BoardMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;
    @Autowired
    private FileUtils fileUtils;

    @Override
    public Page<BoardDTO> selectPageList(int pageNum)throws Exception {

        PageHelper.startPage(pageNum, 6);
        return boardMapper.selectPageList();
    }


    @Override
    public BoardDTO selectBoardDetail(int cmIdx) throws Exception{
        boardMapper.updateHitCount(cmIdx);
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
    public void insertBoard(BoardDTO board, MultipartHttpServletRequest multipart)throws Exception {
        boardMapper.insertBoard(board);


        List<BoardDTO> fileList = fileUtils.parseFileInfo(board.getCmIdx(), multipart);

        //CollectionUtils: 스프링 프레임워크에서 제공하는 컬렉션 타입의 객체를 활용할 수 있는 클래스
        if (CollectionUtils.isEmpty(fileList) == false) {
            boardMapper.insertBoardFileList(fileList);
        }

        // ObjectUtils : 스프링프레임워크에서 제공하는 클래스로 해당 객체가 비었는지 확인함.
//    if (ObjectUtils.isEmpty(multipart) == false) {
        //getFileNames() : 가져온 파일 정보에서 모든 파일 이름을 출력.\
        //Iterator 반복자 -> 배열
//      Iterator<String> iterator = multipart.getFileNames();
//      String name;
//
//      while (iterator.hasNext()) {
//        name = iterator.next();
//        List<MultipartFile> fileInfoList = multipart.getFiles(name);
//
//        for (MultipartFile fileInfo : fileInfoList) {
//          System.out.println("\n***** 파일 정보 *****\n");
//          System.out.println("file name : " + fileInfo.getOriginalFilename());
//          System.out.println("file size : " + fileInfo.getSize());
//          System.out.println("file content type : " + fileInfo.getContentType());
//          System.out.println("\n\n");
//        }
//      }
//    }
    }
}
