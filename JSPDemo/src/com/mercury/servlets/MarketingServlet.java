package com.mercury.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mercury.beans.User;
import com.mercury.beans.UserInfo;
import com.mercury.services.RegistrationService;
import com.mercury.services.TrainingService;

/**
 * Servlet implementation class MarketingServlet
 */
@WebServlet("/ms")
public class MarketingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TrainingService ts = new TrainingService();
	private RegistrationService rs = new RegistrationService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MarketingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("<!DOCTYPE html>\r\n" + 
//				"<html>\r\n" + 
//				"<head>\r\n" + 
//				"<meta charset=\"ISO-8859-1\">\r\n" + 
//				"<title>Hello Nov 2019</title>\r\n" + 
//				"</head>\r\n" + 
//				"<body>\r\n" + 
//				"Welcome to holiday season service() !\r\n" + 
//				"</body>\r\n" + 
//				"</html>");
//	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		
		User u = ts.pick(name);
		
		response.getWriter().append("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"ISO-8859-1\">\r\n" + 
				"<title>Hello Nov 2019</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"For name : " + name + ", got: " + u + "\r\n" + 
				"</body>\r\n" + 
				"</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		rs.register(name, age);
		
		List<User> users = ts.train();
		
		
		UserInfo ui = new UserInfo(users);
		
		request.setAttribute("userInfo", ui);
		
		String url = "/result.jsp";
		
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
