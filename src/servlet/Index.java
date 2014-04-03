package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Index() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String periodo = request.getParameter("periodo");
		
		int periodoInt = 0;
		try {
			periodoInt = Integer.parseInt(periodo);
		} catch (NumberFormatException e) {	
			periodoInt = 0;
		}
		
		String comprimento = "";
		
		if (1 == periodoInt) {
			comprimento = ", bom dia";
		} else if (2 == periodoInt) {
			comprimento = ", boa tarde";
		} else if (3 == periodoInt){
			comprimento = ", boa noite";
		}
		
		request.setAttribute("nome", nome);
		request.setAttribute("comprimento", comprimento);
		RequestDispatcher rd = request.getRequestDispatcher("saudacoes.jsp");
		rd.forward(request, response);
	}
}

