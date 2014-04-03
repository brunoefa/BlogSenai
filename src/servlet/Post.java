package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/post")
public class Post extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Post() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titulo = request.getParameter("titulo");
		String texto = request.getParameter("texto");
		String resumo = request.getParameter("resumo");
		String autor = request.getParameter("autor");
		
		request.setAttribute("titulo", titulo);
		request.setAttribute("texto", texto);
		request.setAttribute("resumo", resumo);
		request.setAttribute("autor", autor);
		
		RequestDispatcher rd = request.getRequestDispatcher("artigo-completo.jsp");
		rd.forward(request, response);
	}
}
