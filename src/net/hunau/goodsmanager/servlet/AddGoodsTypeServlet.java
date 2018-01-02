package net.hunau.goodsmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hunau.goodsmanager.bean.GoodsType;
import net.hunau.goodsmanager.dao.GoodsDAO;
import net.hunau.goodsmanager.dao.TypeDAO;

public class AddGoodsTypeServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public AddGoodsTypeServlet() {
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

		doPost(request, response);
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

		request.setCharacterEncoding("utf-8");
		/*	
		 * private int id;
		 * private String typeName;
		 * private String typeDec;
		 */
		//int id = Integer.parseInt(request.getParameter("idError"));
		String idTemp = request.getParameter("typeID");
		String typeName = request.getParameter("typeName");
		String typeDec = request.getParameter("typeDec");
		GoodsType goodsType = new GoodsType();
		
		if(idTemp != null || idTemp.equals("")){
			int id = Integer.valueOf(idTemp);
			goodsType.setId(id);
			goodsType.setTypeName(typeName);
			goodsType.setTypeDec(typeDec);
		}
		
		
		
		
		TypeDAO typeDAO = new TypeDAO();
		typeDAO.addType(goodsType);
		
		String toPage = "ScanGoodServlet";
		RequestDispatcher rd = request.getRequestDispatcher(toPage);
		rd.forward(request, response);
		
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
