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
import java.util.stream.Collectors;

@WebServlet(value = "/add")
public class AddTeacher extends HttpServlet {
    private List<Person> people;
    private PersonRepository personRepository;


    @Override
    public void init() throws ServletException {
        personRepository = PersonRepositoryInMemory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<Integer, Person> people = personRepository.findAll();
        Map<Integer, Teacher> teachers = filterTeacher(people);
        req.setAttribute("teachers", teachers);
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/add.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        List<Integer> salary = Collections.singletonList(Integer.parseInt(req.getParameter("salary")));
        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacher.setAge(age);
        teacher.setSalary(salary);
        personRepository.save(teacher);

        doGet(req, resp);

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
