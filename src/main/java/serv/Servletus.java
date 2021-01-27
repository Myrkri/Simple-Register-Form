package serv;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;

public class Servletus extends HttpServlet {

    DbConnect db = new DbConnect();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            underProcess(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            processRequests(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processRequests(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String name = req.getParameter("name");
        String pass = req.getParameter("psw");

 //       req.getRequestDispatcher("index.jsp").forward(req, resp);

        if (name != null && pass != null) {
            System.out.println(name);
            System.out.println(pass);

            try {
                db.insertDB(name, pass);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        resp.sendRedirect(req.getContextPath() + "/servlet");

        //req.getRequestDispatcher("return.jsp").forward(req, resp);
    }
    private void underProcess(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        String name = req.getParameter("name");

        String userName = "";
        String pass = "";

        System.out.println(name);

        ResultSet result = db.selectData(name);

        while (result.next()) {
            userName = result.getString("Name");
            pass = result.getString("Password");

            System.out.println("Uswers " + userName);
            System.out.println("Passes " + pass);
        }

        req.setAttribute("user", userName);
        req.setAttribute("password", pass);
        req.getRequestDispatcher("return.jsp").forward(req, resp);

    }

}
