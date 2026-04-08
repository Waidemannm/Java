package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.VerificarCpf;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Cpf
 */
@WebServlet("/CpfServlet")
public class CpfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CpfServlet() {
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
		String cpf = request.getParameter("cpf");
		VerificarCpf cpfVerificar = new VerificarCpf(cpf);
		if(cpfVerificar.verificarCpf() == true) {
			out.print("<html>"
					+ "<head><meta charset=\"UTF-8\">"
					+ "<title>Resultado do CPF</title></head>"
					+ "<body>"
					+ "<div style=\"text-align: center;\">"
					+ "<h1><b> O CPF é válido! "
					+ "</b></h1>"
					+ "</div>"
					+ "</body>"
					+ "</html>");
		}else {
			out.print("<html>"
					+ "<head><meta charset=\"UTF-8\">"
					+ "<title>Resultado do CPF</title></head>"
					+ "<body>"
					+ "<div style=\"text-align: center;\">"
					+ "<h1><b> O CPF é inválido! "
					+ "</b></h1>"
					+ "</div>"
					+ "</body>"
					+ "</html>");
		}
		
	}

}
