package com.boot.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.boot.dao.UserDAO;
import com.boot.servlet.InitServlet;

public class UserDAOImpl implements UserDAO {

	@Override
	public Map<String, String> 
	selectUserInfoByIdAndPwd(Map<String, String> user) {
		Connection con = InitServlet.getConnection();
		PreparedStatement ps = null;
		String sql = "select * from user_info where ui_id=? and ui_password=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.get("uiId"));
			ps.setString(2, user.get("uiPassword"));
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Map<String, String> tmpUser = new HashMap<>();
				tmpUser.put("ui_name", rs.getString("ui_name"));
				tmpUser.put("ui_id", rs.getString("ui_id"));
				tmpUser.put("ui_age", rs.getString("ui_age"));
				tmpUser.put("ui_nickname", rs.getString("ui_nickname"));
				return tmpUser;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			InitServlet.close(ps, con);
		}
		
		return null;
	}

}
