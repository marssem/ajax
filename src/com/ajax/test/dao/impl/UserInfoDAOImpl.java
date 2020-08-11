package com.ajax.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ajax.test.common.Connector;
import com.ajax.test.dao.UserInfoDAO;

public class UserInfoDAOImpl implements UserInfoDAO {

	@Override
	public int insertUserInfo(Map<String, String> ui) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null; 
		try {
			con = Connector.con();
			String sql = "insert into user_info(ui_num,ui_name,ui_age,ui_birth,ui_id,ui_passsword,"
					+ "ui_phone,ui_email,ui_credat,ui_nickname) "
					+ "values(seq_ui_num.nextval,?,?,?,?,?,?,?,sysdate,?)";
			ps = con.prepareStatement(sql);
			ps.setObject(1, ui.get("ui_name"));
			ps.setObject(2, ui.get("ni_age"));
			ps.setObject(3, ui.get("ui_birth"));
			ps.setObject(4, ui.get("ui_id"));
			ps.setObject(5, ui.get("ui_passsword"));
			ps.setObject(6, ui.get("ui_phone"));
			ps.setObject(7, ui.get("ui_email"));
			ps.setObject(8, ui.get("ui_nickname"));
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				if(ps!=null) ps.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if(con!=null)con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public int updateUserInfo(Map<String, String> ui) {
		int result = 0;
		Connection con;
		PreparedStatement ps = null; 
		try {
			con = Connector.con();
			String sql = "update user_info set ui_name=?, ui_age=?,"
					+ "ui_birth=?,ui_passsword=?," 
					+ "ui_phone=?,ui_email=?,ui_nickname=? where ui_num=?";
			ps = con.prepareStatement(sql);
			ps.setObject(1, ui.get("ui_name"));
			ps.setObject(2, ui.get("ui_age"));
			ps.setObject(3, ui.get("ui_birth"));
			ps.setObject(4, ui.get("ui_passsword"));
			ps.setObject(5, ui.get("ui_phone"));
			ps.setObject(6, ui.get("ui_email"));
			ps.setObject(7, ui.get("ui_nickname"));
			ps.setObject(8, ui.get("ui_num"));
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteUserInfo(Map<String, String> ui) {
		int result = 0;
		Connection con;
		PreparedStatement ps = null; 
		
		try {
			con = Connector.con();
			String sql = "delete from user_info where ui_num=?";
			ps = con.prepareStatement(sql);
			ps.setObject(1,ui.get("ui_num"));
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Map<String,String> selecttUserInfo (Map<String,String> ui) {
		Map<String,String> rMap = new HashMap<>();
		return null;
	}

	@Override
	public List<Map<String,String>> selectListUserInfo (Map<String,String> ui) {
		// TODO Auto-generated method stub
		return null;
	}
public static void main(String[] args) {
	UserInfoDAO ui = new UserInfoDAOImpl();
	Map<String,String> i = new HashMap<>();
	i.put("ui_name", "b");
	i.put("ui_num", "3");
	i.put("ui_age","5");
	i.put("ui_birth","b");
	i.put("ui_id","b");
	i.put("ui_passsword","a");
	i.put("ui_phone","b");
	i.put("ui_email","a");
	i.put("ui_nickname","b");
	System.out.println(ui.updateUserInfo(i));
}
}
