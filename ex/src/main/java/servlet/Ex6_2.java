package servlet;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ex62")
public class Ex6_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = (int)(Math.random() * 10);
		int num1 = new Random().nextInt(10);
		System.out.println("num:" + num);
		if(num % 2 == 0) {
			RequestDispatcher d = request.getRequestDispatcher("forward.jsp");
			d.forward(request, response);
		} else {
			response.sendRedirect("redirected.jsp");
		}
	}

}
