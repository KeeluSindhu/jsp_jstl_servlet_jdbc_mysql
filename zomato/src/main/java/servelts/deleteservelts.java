package servelts;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DBconnections.zomatoDBconnections;
import services.zomatoservice;
@WebServlet("/delete")
public class deleteservelts extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		zomatoservice zs = new zomatoservice(zomatoDBconnections.getconnection());
		boolean f = zs.deleteById(id);
		if (f) {
			resp.sendRedirect("welcome.jsp");
		} else {
            resp.sendRedirect("welcome.jsp");
		}
	}


}
