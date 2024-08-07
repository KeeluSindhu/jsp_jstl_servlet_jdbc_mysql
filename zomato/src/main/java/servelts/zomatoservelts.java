package servelts;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBconnections.zomatoDBconnections;
import models.zomato;
import services.zomatoservice;
@WebServlet("/register")
public class zomatoservelts extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name=req.getParameter("name");
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	String confirmpassword=req.getParameter("confirmpassword");
	zomato z=new zomato(0, name,email,password,confirmpassword);
	zomatoservice zs= new zomatoservice(zomatoDBconnections.getconnection());
	boolean f=zs.adding(z);
	
	if (f) {
		resp.sendRedirect("welcome.jsp");
		
		
	} else {
        resp.sendRedirect("register.jsp");
	}
}

}
