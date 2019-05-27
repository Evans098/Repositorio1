package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Saludo
 */
@WebServlet(
		description = "Servlet que recibirá un requerimiento desde index.html", 
		urlPatterns = { "/Saludo" }, 
		initParams = { 
				@WebInitParam(name = "Autor", value = "Ivan"), 
				@WebInitParam(name = "Fecha", value = "27-05-2019")
		})

public class Saludo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Saludo() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter salida = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");//tipo mime
		
		String nombre = request.getParameter("nombre");
		
		if (nombre==null||nombre.trim().equals(""))
			nombre = "Desconocido";
		
		salida.append("<!DOCTYPE html>");
		salida.append("<html>");
		salida.append("<head>");
		salida.append("<meta charset='UTF-8'>");
		salida.append("<title>Servlet Saludo</title>");
		salida.append("</head>");
		salida.append("<body>");
		salida.append("<h1>Hola " + nombre + "</h1>");
		salida.append("</body>");
		salida.append("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
