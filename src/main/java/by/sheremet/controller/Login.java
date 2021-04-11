package by.sheremet.controller;

import by.sheremet.modele.Person;
import by.sheremet.repository.PersonRepository;
import by.sheremet.repository.PersonRepositoryInMemory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(value = "/login")
public class Login extends HttpServlet {
    private Map<Integer, Person> people;
    private PersonRepository personRepository;

    @Override
    public void init() throws ServletException {
        personRepository = PersonRepositoryInMemory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (isExist(login, password)){
            HttpSession session = req.getSession();
            session.setAttribute("person", login);
            req.getServletContext().getRequestDispatcher("/").forward(req, resp);
        }else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }

    }

    public boolean isExist(String login, String password) {
        people = personRepository.findAll();
        for (Person person : people.values()) {
            if(person.getLogin().equals(login) && person.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }


}
