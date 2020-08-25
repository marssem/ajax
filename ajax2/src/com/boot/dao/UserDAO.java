package com.boot.dao;

import java.util.Map;

public interface UserDAO {

	public Map<String,String> selectUserInfoByIdAndPwd(Map<String,String>user);
}
