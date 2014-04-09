package com.senai.servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senai.dao.PostDAO;
import com.senai.entity.Post;

@WebServlet("/post")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PostController() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Post post = new Post();

		post.setTitulo(request.getParameter("titulo"));
		post.setTexto(request.getParameter("texto"));
		post.setResumo(request.getParameter("resumo"));
		post.setAutor(request.getParameter("autor"));
		post.setData(Calendar.getInstance().getTime());
		post.setStatus(1);
		
		PostDAO postDAO = new PostDAO();
		postDAO.adiciona(post);

		request.setAttribute("mensagem", "Post salvo com sucesso!");
		RequestDispatcher rd = request .getRequestDispatcher("index");
		rd.forward(request, response);
	}
}
