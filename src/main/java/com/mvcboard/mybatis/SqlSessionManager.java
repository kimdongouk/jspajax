package com.mvcboard.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionManager {
	public static SqlSessionFactory sqlSession;
	static {
		String resource="com/mvcboard/mybatis/config.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlSession = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static SqlSessionFactory getSqlSession() {
		return sqlSession;
	}
}
