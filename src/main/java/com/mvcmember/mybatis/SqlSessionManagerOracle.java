package com.mvcmember.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionManagerOracle {
	public static SqlSessionFactory sqlSession;
	static {
		String resource="com/mvcmember/mybatis/config.xml";
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
