package com.ajax.test.dao;

import java.util.List;
import java.util.Map;

public interface UserInfoDAO {

	int insertUserInfo (Map<String,String> ui);
	int updateUserInfo (Map<String,String> ui);
	int deleteUserInfo (Map<String,String> ui);
	Map<String,String> selecttUserInfo (Map<String,String> ui);
	List<Map<String,String>> selectListUserInfo (Map<String,String> ui);
	
}
