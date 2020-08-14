package com.ajax.test.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.ajax.test.dao.impl.UserInfoDAOImpl;
import com.ajax.test.service.UserService;
import com.ajax.test.servlet.InitServlet;

public class UserServiceImpl implements UserService {
	private UserInfoDAOImpl uiDao = new UserInfoDAOImpl();
	@Override
	public Map<String, Object> dologin(Map<String, String> user) {
		Map<String,Object> rMap = new HashMap<>();
		rMap.put("result", "fail");
		rMap.put("msg", "아이디를 확인해 주세요.");
		String uiId = user.get("ui_id");
		Map<String,Object> tmpUser = uiDao.selectUserInfoByUiId(uiId);
		if(tmpUser!=null) {
			String tmpUiPwd = tmpUser.get("ui_password").toString();
			String uiPwd = user.get("ui_password");
			if(tmpUiPwd.equals(uiPwd)) {
				rMap.put("result", "ok");
				rMap.put("msg", "로그인 완료");
				rMap.put("user", tmpUser);
			}
		}
		return rMap;
	}

	@Override
	public Map<String, Object> joinUserInfo(Map<String, Object> user) {
		int result = uiDao.insertUserInfo(user);
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("result", result);
		rMap.put("msg","가입실패");
		if(result==1) {
			rMap.put("msg","가입완료");
			rMap.put("url", "/views/login");
		}
		return rMap;
	}
public static void main(String[] args) {
	InitServlet is = new InitServlet();
	is.init();
	UserService us = new UserServiceImpl();
	Map<String,Object> map = new HashMap<>();
	map.put("ui_name",2);
	map.put("ui_age",2);
	map.put("ui_birth",2);
	map.put("ui_id",2);
	map.put("ui_password",2);
	map.put("ui_phone",2);
	map.put("ui_email",2);
	map.put("ui_nickname",2);
	System.out.println(us.joinUserInfo(map));
}

@Override
public Map<String, Object> checkId(String uiId) {
	Map<String,Object> rMap = new HashMap<>();
	rMap.put("msg", "이미 있는 아이디 입니다.");
	if(uiDao.selectUserInfoByUiId(uiId)==null) {
		rMap.put("msg", "가입이 가능한 아이디 입니다.");
	}
	return rMap;
}
}
