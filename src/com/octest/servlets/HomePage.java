package com.octest.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.octest.beans.Note;
import com.octest.dao.NoteD;



@WebServlet("/Test")
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomePage() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		String username =(String)session.getAttribute("username");
		if ( username==null) {
			response.sendRedirect("login");

		}else{
			NoteD noteD= new NoteD();
			List<Note> listNotes = new ArrayList<Note>();
		
			int user_id=(int)session.getAttribute("id");
			 listNotes=noteD.selectAllNote(user_id);
				
				request.setAttribute("listNotes", listNotes);
				this.getServletContext().getRequestDispatcher("/WEB-INF/HomePage.jsp").forward(request, response);	
		}
		
			
			
				
					}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
