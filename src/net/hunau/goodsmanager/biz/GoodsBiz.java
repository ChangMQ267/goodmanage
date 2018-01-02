package net.hunau.goodsmanager.biz;

import java.util.ArrayList;
import java.util.List;

import net.hunau.goodsmanager.bean.Goods;
import net.hunau.goodsmanager.dao.GoodsDAO;

public class GoodsBiz {
	
	 private GoodsDAO goodsDAO=null;
	
	public GoodsBiz(){
		goodsDAO = new GoodsDAO();
	}
	
	public void addGoods(Goods goods){
		goodsDAO.addGoods(goods);
	}
	
	public List<Goods> getGoods(){
		
		return goodsDAO.getGoods();
		
	
	}
	public List<Goods> findGoods(Goods condition){
		
		List<Goods> goods = new ArrayList<Goods>();
		
		if(condition.getId() != 0){ 
			goods.add(goodsDAO.getGoods(condition.getId()));
			
		}else if(condition.getGoodname() != null || condition.getGoodname().equals("")){
			goods.addAll(goodsDAO.getGoods(condition.getGoodname()));
		
		}
		
		return goods;
	}
}
