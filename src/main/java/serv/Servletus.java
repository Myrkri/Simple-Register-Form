package serv;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servletus extends HttpServlet {

    DbConnect db = new DbConnect();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String pass = req.getParameter("psw");

        req.getRequestDispatcher("index.jsp").forward(req, resp);


        if (name != null && pass != null) {
            System.out.println(name);
            System.out.println(pass);

            try {
                //  db.senData();
                db.insertDB(name, pass);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
