package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Moeda;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Moeda
 */
@WebServlet("/MoedaServlet") 
public class MoedaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MoedaServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Double taxa =Double.parseDouble(request.getParameter("taxa"));
		Double valor = Double.parseDouble(request.getParameter("valor"));
		Moeda moeda = new Moeda(valor, taxa);
				out.print("<html>"
						+ "<head><meta charset=\"UTF-8\">"
						+ "<title>Resultado do valor convertido</title></head>"
						+ "<body>"
						+ "<div style=\"text-align: center;\">"
						+ "<h1><b> O valor convertido é : "
		                + moeda.converter()
						+ "</b></h1>"
						+ "</div>"
						+ "</body>"
						+ "</html>");
			
		}
	}

