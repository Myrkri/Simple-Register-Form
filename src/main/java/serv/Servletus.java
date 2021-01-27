package serv;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        if (req.getParameter("checker") != null) {
            resp.sendRedirect(req.getContextPath() + "/servlet");
        } else {
            try {
                processRequests(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void processRequests(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String name = req.getParameter("name");
        String pass = req.getParameter("psw");
        boolean errCheck;

        if (name != null && pass != null) {
            try {
                errCheck = db.insertDB(name, pass);

                 if (!errCheck) {
                    req.setAttribute("err", "Username already exists!");

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
    private void underProcess(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        String name = req.getParameter("name");

        String userName = "";
        String pass = "";

        ResultSet result = db.selectData(name);

        while (result.next()) {
            userName = result.getString("Name");
            pass = result.getString("Password");
        }

        req.setAttribute("user", userName);
        req.setAttribute("password", pass);
        req.getRequestDispatcher("return.jsp").forward(req, resp);
    }

}
