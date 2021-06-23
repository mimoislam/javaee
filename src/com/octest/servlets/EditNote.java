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

/**
 * Servlet implementation class EditNote
 */
@WebServlet("/EditNote")
public class EditNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditNote() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession();
		String username =(String)session.getAttribute("username");
		if ( username==null) {
			response.sendRedirect("login");

		}else{
			NoteD noteD= new NoteD();
			int id=Integer.parseInt(request.getParameter("id"));
				Note note=noteD.selectNoteById(id);

				request.setAttribute("note", note);
				this.getServletContext().getRequestDispatcher("/WEB-INF/EditPage.jsp").forward(request, response);	
		}	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession();
		String username =(String)session.getAttribute("username");
		if ( username==null) {
			response.sendRedirect("login");

		}else{
			NoteD noteD= new NoteD();
			int id=(int)session.getAttribute("id");
			String text=request.getParameter("note");
			Note note=new Note(text,id);

				noteD.updateNoteById(note, id);
				response.sendRedirect("home");

		}

}

}
