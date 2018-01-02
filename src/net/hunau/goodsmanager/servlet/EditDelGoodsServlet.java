package net.hunau.goodsmanager.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.hunau.goodsmanager.bean.Goods;
import net.hunau.goodsmanager.bean.GoodsType;
import net.hunau.goodsmanager.dao.GoodsDAO;
import net.hunau.goodsmanager.dao.TypeDAO;

public class EditDelGoodsServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public EditDelGoodsServlet() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	@SuppressWarnings("null")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String goodsID = request.getParameter("goodsid");
		String op = request.getParameter("op");
		String toPage = null;
		int ID = 0;

		GoodsDAO goodsDAO = new GoodsDAO();
		Goods goods = new Goods();
		TypeDAO typeDAO = new TypeDAO();
		List<GoodsType> goodsTypes = new ArrayList<GoodsType>();
		HttpSession session = request.getSession();

		if (goodsID != null || goodsID.equals("")) {
			ID = Integer.parseInt(goodsID);

			if ("del".equals(op)) {
				goodsDAO = new GoodsDAO();
				goodsDAO.delGoods(ID);
				toPage = "ScanGoodServlet";
			} else {
				goods = goodsDAO.getGoods(ID);
				goodsTypes = typeDAO.scanAllGoodsType();
				session.setAttribute("goods2", goods);
				session.setAttribute("goodsTypes", goodsTypes);
				toPage = "/content/goodsManager/updateGoods.jsp";
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(toPage);
		rd.forward(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
