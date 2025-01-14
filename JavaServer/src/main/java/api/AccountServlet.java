package api;


import dao.AccountDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;


import java.io.*;
import com.google.gson.Gson;
import service.AccountService;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {
    private AccountDAO accountDAO;
    private AccountService accountService;

    @Override
    public void init() {
        accountDAO = new AccountDAO();
        accountService = new AccountService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException  {
        resp.setContentType("application/json");
        BufferedReader reader = req.getReader();
        Account ReqAccount = new Gson().fromJson(reader, Account.class);
        try {
            String id = req.getParameter("id");
            Object obj = req.getParameter("params");
                Account account = accountDAO.getAccount(id);
                String json = new Gson().toJson(account);
                resp.getWriter().write(json);

        } catch (IOException e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to retrieve tasks.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader reader = req.getReader();
        Account account = new Gson().fromJson(reader, Account.class);
        try {
            accountService.createAccount(account);

            resp.setStatus(HttpServletResponse.SC_CREATED);
        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to create task.");
        }
    }

//    @Override
//    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        BufferedReader reader = req.getReader();
//        Account task = new Gson().fromJson(reader, Account.class);
//        try {
//            accountService.deposit(task);
//            resp.setStatus(HttpServletResponse.SC_OK);
//        } catch (SQLException e) {
//            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to update task.");
//        }
//    }

//    @Override
//    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int id = Integer.parseInt(req.getParameter("id"));
//        try {
//            taskDAO.deleteTask(id);
//            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
//        } catch (SQLException e) {
//            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to delete task.");
//        }
//    }
}
