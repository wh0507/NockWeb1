package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sogo.ShohinBean;
import sogo.ShohinDAO;

@WebServlet("/ListControlServlet")
public class ListControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//		doPost(request, response);

		//DBからデータを取得
		ShohinDAO dao = new ShohinDAO();
		ArrayList<ShohinBean> ShohinList = dao.selectAll();

		//アプリケーションスコープにデータを保存
		HttpSession session = request.getSession();
		session.setAttribute("ShohinList", ShohinList);

		//フォワード
		String fwPath = "./web/jsp/ichiran.jsp?no=1";
		RequestDispatcher dispatcher = request.getRequestDispatcher(fwPath);
		dispatcher.forward(request, response);

	}

	//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	//			throws ServletException, IOException {
	//		//DBからデータを取得
	//		ShohinDAO dao = new ShohinDAO();
	//		ArrayList<ShohinBean> ShohinList = dao.selectAll();
	//
	//		//アプリケーションスコープにデータを保存
	//		HttpSession session = request.getSession();
	//		session.setAttribute("ShohinList", ShohinList);
	//
	//		//フォワード
	//		String fwPath = "./web/jsp/ichiran.jsp?=1";
	//		RequestDispatcher dispatcher = request.getRequestDispatcher(fwPath);
	//		dispatcher.forward(request, response);
	//
	//	}

}
