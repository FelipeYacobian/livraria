package controller;

import dao.EditoraDAO;
import domain.Editora;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/editoras/*")
public class EditoraController extends HttpServlet {

    private EditoraDAO dao = new EditoraDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String action = req.getPathInfo();
        if (action == null) action = "";

        switch (action) {

            case "/cadastro":
                req.getRequestDispatcher("/editora/formulario.jsp").forward(req, res);
                break;

            case "/insercao":
                dao.insert(new Editora(
                        req.getParameter("cnpj"),
                        req.getParameter("nome")
                ));
                res.sendRedirect("lista");
                break;

            case "/remocao":
                dao.delete(Long.parseLong(req.getParameter("id")));
                res.sendRedirect("lista");
                break;

            case "/edicao":
                req.setAttribute("editora",
                        dao.get(Long.parseLong(req.getParameter("id"))));
                req.getRequestDispatcher("/editora/formulario.jsp").forward(req, res);
                break;

            case "/atualizacao":
                dao.update(new Editora(
                        Long.parseLong(req.getParameter("id")),
                        req.getParameter("cnpj"),
                        req.getParameter("nome")
                ));
                res.sendRedirect("lista");
                break;

            default:
                req.setAttribute("listaEditoras", dao.getAll());
                req.getRequestDispatcher("/editora/lista.jsp").forward(req, res);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doGet(req, res);
    }
}