package com.octest.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.octest.beans.User;
import com.octest.dao.UserD;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
				UserD userD= new UserD();
				
					User user=new User(username,password);
					User check=userD.CheckUserLogin(user);
					if (check==null) {
						String error="User does not existe";
						request.setAttribute("error", error);
						this.getServletContext().getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);	
					}else {
						HttpSession session= request.getSession();
						session.setAttribute("username", username);
						session.setAttribute("id", check.getId());
						session.setAttribute("email", check.getEmail());

						session.setAttribute("password", password);

						response.sendRedirect("home");
					}
				
				
			

		
	}

}
