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
		} else if ("publicar".equals(acao) || "salvar".equals(acao)) {
			salvar(request, response);
		} else if ("confirmar".equals(acao)) {
			confirmar(request, response);
		} else if ("deletar".equals(acao)) {
			deletar(request, response);
		} else if ("editar".equals(acao)) {
			editar(request, response);
		}
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Post post = new Post();
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			PostDAO postDAO = new PostDAO();
			post = postDAO.getPost(id);
		} catch (NumberFormatException e) {
			request.setAttribute("mensagem", "Post inválido");
		}
		request.setAttribute("post", post);
		RequestDispatcher rd = request.getRequestDispatcher("novo-artigo.jsp");
		rd.forward(request, response);
	}

	private void deletar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("id", id);
			PostDAO dao = new PostDAO();
			dao.deletar(id);
			request.setAttribute("mensagem", "Post deletado com sucesso");
		} catch (NumberFormatException e) {
			request.setAttribute("mensagem", "Post inválido");
		}
		RequestDispatcher rd = request.getRequestDispatcher("index");
		rd.forward(request, response);
	}

	private void confirmar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			PostDAO dao = new PostDAO();
			Post post = dao.getPost(id);
			request.setAttribute("id", id);
			request.setAttribute("titulo", post.getTitulo());
		} catch (NumberFormatException e) {
			request.setAttribute("mensagem", "Post inválido");
		}
		RequestDispatcher rd = request.getRequestDispatcher("confirmacao.jsp");
		rd.forward(request, response);
	}

	private void salvar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Post post = new Post();
		post.setTitulo(request.getParameter("titulo"));
		post.setTexto(request.getParameter("texto"));
		post.setResumo(request.getParameter("resumo"));
		post.setAutor(request.getParameter("autor"));
		post.setData(Calendar.getInstance().getTime());
		
		String acao = request.getParameter("acao");
		if ("publicar".equals(acao)) {
			post.setStatus(1);
		} else if ("salvar".equals(acao)) {
			post.setStatus(0);
		}
		
		try {
			String stringId = request.getParameter("id");
			Integer id = null;

			if (!stringId.isEmpty()) {
				id = Integer.parseInt(stringId);
			}
			
			PostDAO postDAO = new PostDAO();
			if (id == null) {
				postDAO.adiciona(post);
				request.setAttribute("mensagem", "Post salvo com sucesso!");
			} else {
				post.setId(id);
				postDAO.atualiza(post);
				request.setAttribute("mensagem", "Post atualizado com sucesso!");
			}
			
		} catch (NumberFormatException e) {
			request.setAttribute("mensagem", "Post inválido");
		}

		RequestDispatcher rd = request .getRequestDispatcher("index");
		rd.forward(request, response);
	}
	
	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Post post = new Post();
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			PostDAO postDAO = new PostDAO();
			post = postDAO.getPost(id);
		} catch (NumberFormatException e) {
			request.setAttribute("mensagem", "Post inválido");
		}
		request.setAttribute("post", post);
		RequestDispatcher rd = request.getRequestDispatcher("artigo-completo.jsp");
		rd.forward(request, response);
	}
}
