package com.mercury.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.mercury.beans.User;
import com.mercury.utils.JdbcUtil;

public class UserDao {

	public void save(User u) {
		String sql = "{?=call saveUser(?,?)}";

		try(Connection connection = JdbcUtil.getConnection();
				CallableStatement cs = connection.prepareCall(sql)) {
			
			cs.setString(2, u.getName());
			cs.setInt(3, u.getAge());
			
			cs.registerOutParameter(1, Types.INTEGER);
			
			cs.execute();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<User> getAll() {
		String sql = "select * from sample";
		
		List<User> users = new ArrayList();
		
		try (Connection connection = JdbcUtil.getConnection();
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(sql);) {
			
			while(rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				users.add(new User(name, age));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return users;
	}
	
	public User getById(String name) {
		// ? placeholder
		String sql = "select * from sample where name = ?";
		User u = null;
		
		try (Connection connection = JdbcUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);) {
			
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String nm = rs.getString("name");
				int ag = rs.getInt("age");
				
				u = new User(nm, ag);
			}
			
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return u;
	}
}
