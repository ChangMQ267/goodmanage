package net.hunau.goodsmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.hunau.goodsmanager.bean.Roles;
import net.hunau.goodsmanager.utils.JDBCUtils;

public class RoleDAO {
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement pst;
	
	public List<Roles> getRoles(){
		List<Roles> roles= new ArrayList<Roles>();
		Roles role = null;
		String sql = ("Select * From Roles");
		try {
			conn = JDBCUtils.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()){
				role = new Roles();
				role.setId(rs.getInt("id"));
				role.setRoleDesc(rs.getString("roleDesc"));
				role.setRoleName(rs.getString("roleName"));
				roles.add(role);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				JDBCUtils.release(rs, pst, conn);
		}
		
		return roles;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
