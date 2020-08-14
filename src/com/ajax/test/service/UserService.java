package com.ajax.test.service;

import java.util.Map;

public interface UserService {
	Map<String,Object> dologin(Map<String,String> user);
	Map<String,Object> joinUserInfo(Map<String,Object> user);
	Map<String, Object> checkId(String uiId);
}
