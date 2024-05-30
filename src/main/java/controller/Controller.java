package controller;

import model.Contato;
import model.DAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete", "/report" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DAO dao = new DAO();
	Contato contato = new Contato();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String action = request.getServletPath();

        switch (action) {
            case "/main" -> contatos(request, response);
            case "/select" -> listarContato(request, response);
            case "/delete" -> deletarContato(request, response);
            default -> response.sendRedirect("index.html");
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		request.setCharacterEncoding("UTF-8");

		String action = request.getServletPath();

		if (action.equals("/insert")) {
			novoContato(request, response);
		} else if (action.equals("/update")) {
			editarContato(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	protected void contatos(HttpServletRequest request, HttpServletResponse response) {

		List<Contato> listaContatos = dao.listarContatos();

		request.setAttribute("contatos", listaContatos);

		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");

		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
    }

	protected void novoContato(HttpServletRequest request, HttpServletResponse response) {

		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));

		Map<Boolean, String> resp = dao.inserirContato(contato);

		if (resp.containsKey(Boolean.TRUE)) {

			request.setAttribute("entradaDuplicada", resp);

			RequestDispatcher rd = request.getRequestDispatcher("novo.jsp");

			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				response.sendRedirect("main");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	protected void listarContato(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");

		contato.setId(id);

		Contato dadosContato = dao.selecionarContato(contato.getId());

		request.setAttribute("contato", dadosContato);

		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");

		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
    }

	protected void editarContato(HttpServletRequest request, HttpServletResponse response) {

		contato.setId(request.getParameter("id"));
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));

		dao.editarContato(contato);

		try {
			response.sendRedirect("main");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void deletarContato(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");

		dao.deletarContato(id);

		try {
			response.sendRedirect("main");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
