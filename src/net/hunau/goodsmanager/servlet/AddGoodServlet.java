package net.hunau.goodsmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hunau.goodsmanager.bean.Goods;
import net.hunau.goodsmanager.biz.GoodsBiz;

public class AddGoodServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public AddGoodServlet() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String goodname = request.getParameter("ProductName");
		double goodprice = Double.valueOf(request.getParameter("productPrice"));
		int goodcount = Integer.valueOf(request.getParameter("productNumber"));
		String goodDep = request.getParameter("description");
		int goodtype = Integer.valueOf(request.getParameter("goodsType"));
		
		Goods goods = new Goods();
		goods.setGoodname(goodname);
		goods.setGoodprice(goodprice);
		goods.setGoodcount(goodcount);
		goods.setGoodDep(goodDep);
		goods.setGoodtype(goodtype);
		
		GoodsBiz goodsBiz = new GoodsBiz();
		goodsBiz.addGoods(goods);
		
		
		String toPage = request.getContextPath() + "/content/goodsManager/searchGoods.jsp";
		response.sendRedirect(toPage);
	
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
