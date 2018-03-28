package com.board.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.board.domain.BoardCommand;

//SqlSessionDaoSupport 상속->SqlSession객체를 자동(getSqlSession())
public class BoardDaoImpl extends SqlSessionDaoSupport 
                                                          implements BoardDao {

	//1.글목록보기
	public List<BoardCommand> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<BoardCommand> list=getSqlSession().selectList("selectList",map);
		return list;
	}
    //2.글검색갯수 구하기
	public int getRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectCount",map);
	}
}
