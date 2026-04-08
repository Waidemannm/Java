package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Corrida;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

/**
 * Servlet implementation class CorridaServlets
 */
@WebServlet("/CorridaServlet")
public class CorridaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CorridaServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Double distancia = Double.parseDouble(request.getParameter("distancia"));
		Double velocidade = Double.parseDouble(request.getParameter("velocidade"));
		Corrida corrida = new Corrida(distancia, velocidade);
		out.print("<html>"
				+ "<head><meta charset=\"UTF-8\">"
				+ "<title>Resultado do tempo de viagem</title></head>"
				+ "<body>"
				+ "<div style=\"text-align: center;\">"
				+ "<h1><b> O tempo de viagem é: "
                +corrida.tempoViagem()
				+ "</b></h1>"
				+ "</div>"
				+ "</body>"
				+ "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
