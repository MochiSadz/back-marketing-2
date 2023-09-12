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
public class ControllerAdicionar extends HttpServlet {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The dao. */
	DAO dao = new DAO();

	/** The evento. */
	JavaBeans evento = new JavaBeans();

	/**
	 * Instantiates a new controller.
	 */
	public ControllerAdicionar() {
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
			adicionarEvento(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	/**
	 * Adicionar evento.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 */
	// Novo evento
	protected void adicionarEvento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// teste de recebimento de dados do formulário
		// System.out.println(request.getParameter("nome"));
		// System.out.println(request.getParameter("Endereco"));
		// System.out.println(request.getParameter("Imagem"));
		// setar as variaveis JavaBeans
		evento.setNome(request.getParameter("nome"));
		evento.setEndereco(request.getParameter("endereco"));
		evento.setImagem(request.getParameter("imagem"));
		// invocar o metodo inserirEvento passando o objeto evento
		dao.adicionarEvento(evento);
		// redirecionar para o documento dashboard.html
		response.sendRedirect("dashboard");
	}
}