package com.senai.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senai.dao.PostDAO;
import com.senai.entity.Post;

@WebServlet("/index")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IndexController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostDAO dao = new PostDAO();
		List<Post> lista = dao.getLista(Boolean.TRUE);
		request.setAttribute("lista", lista);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}
}

