package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.WarehouseNew;
import es.salesianos.service.WarehouseNewService;


public class RecoveryAddIdWarehouseNewServlet extends HttpServlet{
	WarehouseNewService service = new WarehouseNewService();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		WarehouseNew warehouseForm= new WarehouseNew();
		warehouseForm.setId(Integer.parseInt(id));
		req.setAttribute("warehouse", warehouseForm);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addBookNew.jsp");
		dispatcher.forward(req,resp);
	}
}
