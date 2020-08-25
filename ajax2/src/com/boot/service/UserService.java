package com.boot.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

public interface UserService {

	public boolean doLogin(Map<String,String>param, HttpSession hs);
}
