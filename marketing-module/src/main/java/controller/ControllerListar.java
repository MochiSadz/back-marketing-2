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
public class ControllerListar extends HttpServlet {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The dao. */
	DAO dao = new DAO();

	/** The evento. */
	JavaBeans evento = new JavaBeans();

	/**
	 * Instantiates a new controller.
	 */
	public ControllerListar() {
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
			listarEvento(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	/**
	 * Listar evento.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 */
	// Editar evento
	protected void listarEvento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recebimendo do id do evento que sera editado
		String idev = request.getParameter("idev");
		// System.out.println(idev);

		// Setar a variavel JavaBeans
		evento.setIdev(idev);
		// Executar o método selecionarContato (DAO)
		dao.selecionarEvento(evento);
		// teste de recebimento
		// System.out.println(evento.getIdev());
		// System.out.println(evento.getNome());
		// System.out.println(evento.getEndereco());
		// System.out.println(evento.getImagem());

		// setar os atributos do formulario com o conteudo do JavaBeans
		request.setAttribute("idev", evento.getIdev());
		request.setAttribute("nome", evento.getNome());
		request.setAttribute("Endereco", evento.getEndereco());
		request.setAttribute("Imagem", evento.getImagem());
		// encaminhar ao documento dashboard
		RequestDispatcher rd = request.getRequestDispatcher("dashboard");
		rd.forward(request, response);
		;
	}
}