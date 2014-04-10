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
		String acao = request.getParameter("acao");
		if (("mostrar").equals(acao)) {
			mostrar(request, response);
		} else if ("salvar".equals(acao)) {
			adicionar(request, response);
		}
	}
	
	
	
	
	
	
	
	private void adicionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	
	private void mostrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Post post = new Post();
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			PostDAO postDAO = new PostDAO();
			post = postDAO.getPost(id);
		} catch (NumberFormatException e) {
			request.setAttribute("mensagem", "Post inv�lido");
		}
		request.setAttribute("post", post);
		RequestDispatcher rd = request.getRequestDispatcher("artigo-completo.jsp");
		rd.forward(request, response);
	}
}
