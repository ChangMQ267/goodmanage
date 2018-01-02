package net.hunau.goodsmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import net.hunau.goodsmanager.bean.GoodsType;
import net.hunau.goodsmanager.utils.JDBCUtils;

public class TypeDAO {
	
	private Connection conn = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	

	public List<GoodsType> scanAllGoodsType(){
		
		List<GoodsType> typesAll = new ArrayList<GoodsType>();
		
		String sql = "select id,typename,typedes from goodstype";
		
		try {
			conn = JDBCUtils.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			 
			while(rs.next()){
				GoodsType  goodsType = new GoodsType();
				goodsType.setId(rs.getInt("id"));
				goodsType.setTypeDec(rs.getString("typedes"));
				goodsType.setTypeName(rs.getString("typename"));
				typesAll.add(goodsType);
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
		
		
		return typesAll;
		
	}
	
	public void addType(GoodsType goodsType){
		//id, typename, typedes
		String sql = "Insert into goodstype(typename, typedes, id) values(?,?,?)";
		
		try {
			conn = JDBCUtils.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, goodsType.getTypeName());
			pst.setString(2, goodsType.getTypeDec());
			pst.setInt(3, goodsType.getId());
			pst.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.release(pst, conn);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
