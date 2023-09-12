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
public class ControllerEditar extends HttpServlet {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The dao. */
	DAO dao = new DAO();

	/** The evento. */
	JavaBeans evento = new JavaBeans();

	/**
	 * Instantiates a new controller.
	 */
	public ControllerEditar() {
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
			editarEvento(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	/**
	 * Editar evento.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 */
	protected void editarEvento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// teste de recebimento
		// System.out.println(request.getParameter("idev"));
		// System.out.println(request.getParameter("nome"));
		// System.out.println(request.getParameter("endereco"));
		// System.out.println(request.getParameter("imagem"));

		// setar as variáveis JavaBeans
		evento.setIdev(request.getParameter("idev"));
		evento.setNome(request.getParameter("nome"));
		evento.setEndereco(request.getParameter("endereco"));
		evento.setImagem(request.getParameter("imagem"));
		// executar o método alterar evento
		dao.alterarEvento(evento);
		// redirecionar para o documento dashboard (atualizando as alteracoes)
		response.sendRedirect("dashboard");
	}
}