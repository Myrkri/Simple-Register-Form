package serv;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

       req.getRequestDispatcher("return.jsp").forward(req, resp);

        String name = req.getParameter("name");
        System.out.println(name);
        //db.selectData(name);
    }

}
