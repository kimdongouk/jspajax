package com.mvcboard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mvcboard.mybatis.SqlSessionManager;
import com.mvcboard.vo.BoardVO;

public class BoardDAO {
	
//	db - SqlSession
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	SqlSession sqlSession = sqlSessionFactory.openSession(true); //autocommit

	public List<BoardVO> getBoardList(){
		List<BoardVO> list = null;
		list = sqlSession.selectList("board.getBoardList");
		return list;
	}
	
	public BoardVO getBoard(int seq){
		BoardVO vo = null;
		vo = sqlSession.selectOne("board.getBoard", seq);
		return vo;
	}
	
	public void updateBoardCnt(int seq) {
		sqlSession.update("board.updateBoardCnt", seq);
	}
}
