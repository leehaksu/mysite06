package com.jx372.mysite.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jx372.mysite.vo.BoardVo;

@Repository
public class BoardDao {
	
	//로그 생성
	private static final Log LOG = LogFactory.getLog(BoardDao.class );


	@Autowired
	private SqlSession sqlSession;

	public int getSize() {
		int count=0;
		count = sqlSession.selectOne("board.getsize");
		LOG.debug("[BoardDao]BoardSize : " + count);
		return count;
	}

	public List<BoardVo> getList(int page) {
		List<BoardVo> list = new ArrayList<BoardVo>();
		list = sqlSession.selectList("board.getList", page);
		LOG.info("[BoardDao]Boardlist : " + list);
		return list;

	}

	public BoardVo get(Long no) {
		BoardVo vo = sqlSession.selectOne("board.get", no);
		LOG.info("[BoardDao] BoardVo.get : "+ vo );
		return vo;
	}

	public boolean insert(BoardVo vo) {
		LOG.info("[BoardDao] BoardVo.insert : "+ vo );
		int count = sqlSession.insert("board.insert", vo);
		return count == 1;
	}

	public boolean update(Long no) {
		int count = sqlSession.update("board.updateHit", no);
		LOG.info("BoardDao] BoardDao.updateHit : "+ count) ;
		return count == 1;
	}

	public boolean update(int group_no,int boardNo) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("group_no", group_no);
		map.put("no", boardNo);
		int count = sqlSession.update("board.updateOrder", map);
		LOG.info("BoardDao] BoardDao.updateOrder : "+ map) ;
		return count == 1;
	}

	public boolean update(String title, String content, Long boardNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", title);
		map.put("content", content);
		map.put("no", boardNo);
		int count = sqlSession.update("board.update", map);
		LOG.info("BoardDao] BoardDao.update : "+ map) ;
		return count == 1;
	}

	public BoardVo select(Long no) {
		BoardVo vo = sqlSession.selectOne("board.select", no);
		LOG.info("BoardDao] BoardDao.select : "+ no);
		return vo;
	}

	public boolean delete(Long no) {
		int count = sqlSession.delete("board.delete", no);
		LOG.info("BoardDao] BoardDao.delete : "+ no);
		return count == 1;
	}
}
