package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/Controller", "/header", "/dashboard" })
public class ControllerEvento extends HttpServlet {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The dao. */
	DAO dao = new DAO();

	/** The evento. */
	JavaBeans evento = new JavaBeans();

	/**
	 * Instantiates a new controller.
	 */
	public ControllerEvento() {
		super();
	}

	/**
	 * Do get.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		// teste de recebimento de requisições
		// System.out.println(action);
		if (action.equals("/header")) {
			evento(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	/**
	 * Eventos.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 */
	// evento
	protected void evento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um objeto que irá receber os dados JavaBeans
		ArrayList<JavaBeans> lista = dao.listarEvento();
		// Encaminhar a lista ao documento header
		request.setAttribute("evento", lista);
		RequestDispatcher rd = request.getRequestDispatcher("header.component.html");
		rd.forward(request, response);

		// teste de recebimento da lista
		// for (int i = 0; i < lista.size(); i++) {
		// System.out.println(lista.get(i).getIdev());
		// System.out.println(lista.get(i).getNome());
		// System.out.println(lista.get(i).getEndereco());
		// System.out.println(lista.get(i).getImagem());
		// }

	}
}