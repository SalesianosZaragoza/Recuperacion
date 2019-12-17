package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import es.salesianos.model.User;
import es.salesianos.service.UserService;

public class UpdateServlet extends SpringBaseServlet {

	@Autowired
	UserService service;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("id");
		Integer idUser = Integer.parseInt(parameter);
		User user = service.listById(idUser);
		req.setAttribute("usuario", user);
		redirect(req, resp, "Update.jsp");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * aqui deberia usar UserAssembler.createUserFromRequest y no esta ñapa en la
		 * cual estoy repitiendo codigo NO NO NO NO por fabor
		 */
		String id = req.getParameter("id");
		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		User user = new User();
		user.setId(Integer.parseInt(id));
		user.setNombre(nombre);
		user.setApellido(apellido);
		service.update(user);
		redirect(req, resp, "Listado.jsp");

	}


	protected void redirect(HttpServletRequest req, HttpServletResponse resp, String page)
			throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/" + page);
		dispatcher.forward(req, resp);
	}

}
