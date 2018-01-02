package net.hunau.goodsmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.hunau.goodsmanager.bean.Goods;
import net.hunau.goodsmanager.utils.JDBCUtils;

public class GoodsDAO {
	
	
	private Connection conn = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	
	/**
	 * @param goods
	 */
	/*
	private int id;
	private String goodname;
	private double goodprice;
	private int goodcount;
	private String goodDep;
	private int goodtype;
	 */
	public void addGoods(Goods goods){
		
		String sql = "Insert into goods(goodsName, goodsPrice, goodsCount, goodsDep, goodsType) values(?,?,?,?,?)";
		
		try {
			conn = JDBCUtils.getConnection();
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, goods.getGoodname());
			pst.setDouble(2,goods.getGoodprice());
			pst.setInt(3,goods.getGoodcount());
			pst.setString(4,goods.getGoodDep());
			pst.setInt(5,goods.getGoodtype());
			pst.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JDBCUtils.release(pst, conn);
		}
		
	}
	
	public List<Goods> getGoods(){
		
		List<Goods> goodscan = new ArrayList<Goods>();
		
		String sql = "select * from Goods";
		
		try {
			conn = JDBCUtils.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()){
//				goodsID, goodsName, goodsPrice, goodsCount, goodsDep, goodsType
				Goods goods = new Goods();
				goods.setId(rs.getInt("goodsID"));
				goods.setGoodname(rs.getString("goodsName"));
				goods.setGoodprice(rs.getDouble("goodsPrice"));
				goods.setGoodcount(rs.getInt("goodsCount"));
				goods.setGoodDep(rs.getString("goodsDep"));
				goods.setGoodtype(rs.getInt("goodsType"));
				
				goodscan.add(goods);
				
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
		return goodscan;
	}
	public List<Goods> getGoods(String goodsName){
		List<Goods> goodscan = new ArrayList<Goods>();
		
		String sql = "select * from goods where goodsName like '%" + goodsName + "%'";
		
		try {
			conn = JDBCUtils.getConnection();
			pst  = conn.prepareStatement(sql);
			
			rs = pst.executeQuery();
			while(rs.next()){
				Goods goods = new Goods();
				goods.setId(rs.getInt("goodsID"));
				goods.setGoodname(rs.getString("goodsName"));
				goods.setGoodprice(rs.getDouble("goodsPrice"));
				goods.setGoodcount(rs.getInt("goodsCount"));
				goods.setGoodDep(rs.getString("goodsDep"));
				goods.setGoodtype(rs.getInt("goodsType"));
				
				goodscan.add(goods);
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, pst, conn);
		}
		return goodscan;
	}
	public Goods getGoods(int id){
		
		String sql = "select * from goods where goodsID = "+id;
		Goods goods = null;
		try {
			conn = JDBCUtils.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()){
				goods = new Goods();
				goods.setId(rs.getInt("goodsID"));
				goods.setGoodname(rs.getString("goodsName"));
				goods.setGoodprice(rs.getDouble("goodsPrice"));
				goods.setGoodcount(rs.getInt("goodsCount"));
				goods.setGoodDep(rs.getString("goodsDep"));
				goods.setGoodtype(rs.getInt("goodsType"));
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, pst, conn);
		}
		return goods;
		
	}
	
	public void delGoods(int id){
		
		String sql = "delete from goods where goodsID="+id;
		
		try {
			conn = JDBCUtils.getConnection();
			pst = conn.prepareStatement(sql);
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
	
	/*
	private int id;
	private String goodname;
	private double goodprice;
	private int goodcount;
	private String goodDep;
	private int goodtype;
	 */
	//goodsID, goodsName, goodsPrice, goodsCount, goodsDep, goodsType
	public void updateGoods(Goods goods){
		
		String sql = "Update goods set goodsName=?, goodsPrice=?, goodsCount=?, goodsDep=?, goodsType=? where goodsID=?";
	
		try {
			conn = JDBCUtils.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, goods.getGoodname());
			pst.setDouble(2,goods.getGoodprice());
			pst.setInt(3,goods.getGoodcount());
			pst.setString(4,goods.getGoodDep());
			pst.setInt(5,goods.getGoodtype());
			pst.setInt(6, goods.getId());
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
}
