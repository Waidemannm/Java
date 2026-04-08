package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Bissexto;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

/**
 * Servlet implementation class Bissexto
 */
@WebServlet("/BissextoServlet")
public class BissextoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BissextoServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Integer ano = Integer.parseInt(request.getParameter("ano"));
		Bissexto anoBissexto = new Bissexto(ano);
		if(anoBissexto.bissexto() == true) {
			out.print("<html>"
					+ "<head><meta charset=\"UTF-8\">"
					+ "<title>Resultado de Ano Bissexto</title></head>"
					+ "<body>"
					+ "<div style=\"text-align: center;\">"
					+ "<h1><b> Ano Bissexto"
					+ "</b></h1>"
					+ "</div>"
					+ "</body>"
					+ "</html>");
		}else {
			out.print("<html>"
					+ "<head><meta charset=\"UTF-8\">"
					+ "<title>Resultado de Ano Bissexto</title></head>"
					+ "<body>"
					+ "<div style=\"text-align: center;\">"
					+ "<h1><b> Não é ano Bissexto"
					+ "</b></h1>"
					+ "</div>"
					+ "</body>"
					+ "</html>");
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
