package com.mvcmember.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mvcboard.mybatis.SqlSessionManager;
import com.mvcboard.vo.BoardVO;
import com.mvcmember.mybatis.SqlSessionManagerOracle;
import com.mvcmember.vo.MemberVO;

public class MemberDAOMybatis {
	SqlSessionFactory sqlSessionFactory = SqlSessionManagerOracle.getSqlSession();
	SqlSession sqlSession = sqlSessionFactory.openSession(true); //autocommit
	
	public List<MemberVO> getMemberList(){
		List<MemberVO> list = null;
		list = sqlSession.selectList("member.getMemberList");
		return list;
	}
	
	public MemberVO getMember(String id){
		MemberVO vo = null;
		vo = sqlSession.selectOne("member.getMember", id);
		return vo;
	}
}
