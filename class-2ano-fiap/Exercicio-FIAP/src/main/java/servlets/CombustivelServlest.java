package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Combustivel;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

/**
 * Servlet implementation class CombustivelServlest
 */
@WebServlet("/CombustivelServlest")
public class CombustivelServlest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CombustivelServlest() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Double preco = Double.parseDouble(request.getParameter("preco"));
		Double distancia = Double.parseDouble(request.getParameter("distancia"));
		Double consumo = Double.parseDouble(request.getParameter("consumo"));
		Combustivel combustivel = new Combustivel(distancia, consumo, preco);
		out.print("<html>"
				+ "<head><meta charset=\"UTF-8\">"
				+ "<title>Resultado do tempo de corrida</title></head>"
				+ "<body>"
				+ "<div style=\"text-align: center;\">"
				+ "<h1><b> O custo é R$: "
                + combustivel.custo()
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
