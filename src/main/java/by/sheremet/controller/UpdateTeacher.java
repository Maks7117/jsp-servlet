package by.sheremet.controller;

import by.sheremet.modele.Person;
import by.sheremet.modele.Teacher;
import by.sheremet.repository.PersonRepository;
import by.sheremet.repository.PersonRepositoryInMemory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(value = "/update")
public class UpdateTeacher extends HttpServlet {
    //private Teacher teacher;
    private List<Person> people;
    private PersonRepository personRepository;

    @Override
    public void init() throws ServletException {
        personRepository = PersonRepositoryInMemory.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<Integer, Person> people = personRepository.findAll();
        Map<Integer, Teacher> teachers = filterTeacher(people);
       // List<Integer> salaries = teacher.getSalary();
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        int salary = Integer.parseInt(req.getParameter("salary"));
        Teacher teacher = teachers.get(Integer.parseInt(id));
       // salaries.add(salary);
        teacher.setName(name);
        teacher.getSalary().add(salary);
        resp.sendRedirect(req.getContextPath() + "/show");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<Integer, Person> people = personRepository.findAll();
        Map<Integer, Teacher> teachers = filterTeacher(people);
        String id = req.getParameter("id");
        Teacher teacher = teachers.get(Integer.parseInt(id));
        req.setAttribute("teacher", teacher);
        req.getRequestDispatcher("update.jsp")
                .forward(req, resp);
    }

    private Map<Integer, Teacher> filterTeacher(Map<Integer, Person> people) {
        Map<Integer, Teacher> list = new HashMap<>();
        for (Person person : people.values()) {
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                list.put(teacher.getId(), teacher);
            }
        }
        return list;
    }
}
