package controller;

import dao.*;
import domain.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/livros/*")
public class LivroController extends HttpServlet {

    LivroDAO dao = new LivroDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.setAttribute("listaLivros", dao.getAll());
        req.getRequestDispatcher("/livro/lista.jsp").forward(req,res);
    }
}