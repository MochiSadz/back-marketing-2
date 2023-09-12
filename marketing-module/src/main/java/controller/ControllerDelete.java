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
@WebServlet(urlPatterns = {"/Controller", "/header", "/dashboard"} )
public class ControllerDelete extends HttpServlet {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The dao. */
	DAO dao = new DAO();
	
	/** The evento. */
	JavaBeans evento = new JavaBeans();

	/**
	 * Instantiates a new controller.
	 */
	public ControllerDelete() {
		super();
		
	}
	

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		//teste de recebimento de requisições
		//System.out.println(action);
		if (action.equals("/header")) {
			removerEvento (request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}
	
	/**
	 * Remover evento.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// remover um evento
	protected void removerEvento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recebimento do id do evento a ser excluido (validador.js)
		String idev = request.getParameter("idev");
		// teste de recebimento
		// System.out.println(idev);
		evento.setIdev(idev);
		// executar o método deletarEvento (DAO) passando o objeto evento
		dao.deletarEvento(evento);
		// redirecionar para o documento dashboard (atualizando as alteracoes)
		response.sendRedirect("dashboard");
	}
	
}
