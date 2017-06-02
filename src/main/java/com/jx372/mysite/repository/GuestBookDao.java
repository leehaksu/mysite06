package com.jx372.mysite.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jx372.mysite.vo.GuestBookVo;



@Repository
public class GuestBookDao{
	
	//로그 생성 준비
	private static final Log LOG=LogFactory.getLog(GuestBookDao.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	public boolean insert(GuestBookVo vo) {
		LOG.info("[GuestBookDao] GuestBookDao.insert : "+ vo);
		int count = sqlSession.insert("guestbook.insert", vo);
		return count==1;
	}
	public List<GuestBookVo> getList() {
		List<GuestBookVo> list = new ArrayList<GuestBookVo>();
		list = sqlSession.selectList("guestbook.getList");
		LOG.info("[GuestBookDao] GuestBookDao.getList : "+ list);
		return list;
	}
	public boolean delete(GuestBookVo vo) {
		int count =sqlSession.delete("guestbook.delete", vo);
		LOG.info("[GuestBookDao] GuestBookDao.delete : "+ count);
		return count==1;
	}
}
