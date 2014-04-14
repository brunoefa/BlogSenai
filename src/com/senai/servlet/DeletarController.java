package com.senai.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senai.dao.PostDAO;


@WebServlet("/deletar")
public class DeletarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeletarController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		RequestDispatcher rd;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			request.setAttribute("mensagem", "Post inválido");
		}

		String acao = request.getParameter("acao");
		if (("confirmar").equals(acao)) {
			request.setAttribute("id", id);
			rd = request.getRequestDispatcher("confirmacao.jsp");
			rd.forward(request, response);
		} else if ("deletar".equals(acao)) {
			PostDAO dao = new PostDAO();
			dao.deletar(id);
			request.setAttribute("mensagem", "Post deletado com sucesso");
			rd = request.getRequestDispatcher("index");
			rd.forward(request, response);
		}
	}
}
