package com.jx372.mysite.repository;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jx372.mysite.vo.UserVo;

@Repository
public class UserDao {
	
	private static Log LOG=LogFactory.getLog(UserDao.class);
	
	@Autowired
	private SqlSession sqlSession;

	// 수정폼
	public UserVo get(Long no) {
		// TODO Auto-generated method stub
		UserVo vo=sqlSession.selectOne("user.getByNo",no);
		LOG.info("[UserDao] UserDao.get : "+ vo);
		/*Map를 ResultType으로 사용하는 예제*/
		/*Map map= sqlSession.selectOne("user.getByNo",no);*/
		return vo;
	}

	// 로그인 처리
	public UserVo get(UserVo uservo) {
		// TODO Auto-generated method stub
		LOG.info("[UserDao] UserDao.getUserVo : "+ uservo);
		uservo=sqlSession.selectOne("getByEp",uservo);
		return uservo;
	}

	public boolean insert(UserVo vo) {
		// TODO Auto-generated method stub
		LOG.info("[UserDao] UserDao.insert : "+ vo);
		int count=sqlSession.insert("user.insert",vo);
		return count==1;
	}

	public boolean update(UserVo vo) {
		// TODO Auto-generated method stub
		LOG.info("[UserDa] UserDao.update : "+vo);
		int count=sqlSession.update("user.update",vo);
		return count==1;	
	}

	public UserVo get(String email) {
		// TODO Auto-generated method stub
		LOG.info("[UserDa] UserDao.update : "+email);
		return sqlSession.selectOne("user.getByEmail",email);
		
	}
}
