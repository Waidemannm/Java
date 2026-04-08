package servlets;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
/**
* Servlet implementation class HipotenusaServlet
*/
@WebServlet("/HipotenusaServlet")
public class HipotenusaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HipotenusaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		////////
		Double catetoA = Double.parseDouble(request.getParameter("catetoA"));
		Double catetoB = Double.parseDouble(request.getParameter("catetoB"));
		Double hipotenusa = Math.sqrt(Math.pow(catetoA,2) + Math.pow(catetoB,2));
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>"
				+ "<head><meta charset=\"UTF-8\">"
				+ "<title>Resultado da Hipotenusa</title></head>"
				+ "<body>"
				+ "<div style=\"text-align: center;\">"
				+ "<h1><b> O valor da hipotenusa é "
                + new DecimalFormat("#.##").format(hipotenusa)
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
 