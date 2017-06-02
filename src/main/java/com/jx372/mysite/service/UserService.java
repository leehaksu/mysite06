package com.jx372.mysite.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jx372.mysite.repository.UserDao;
import com.jx372.mysite.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userdao;
	
	public boolean join(UserVo uservo)
	{
		return userdao.insert(uservo);
	}
	
	public UserVo login(UserVo uservo,HttpSession authUser)
	{
		uservo=userdao.get(uservo);
		
		return uservo;
	}

	public UserVo getInformData(UserVo uservo) {
		// TODO Auto-generated method stub
		uservo=userdao.get(uservo.getNo());
		
		return uservo;
	}

	public boolean modify(UserVo uservo) {
		// TODO Auto-generated method stub
		
		return false;
	}
}
