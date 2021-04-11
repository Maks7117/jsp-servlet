package by.sheremet.controller;

import by.sheremet.logic.Salary;
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
import java.util.HashMap;
import java.util.Map;


@WebServlet(value = "/aver")
public class AverageSalary extends HttpServlet {
    private PersonRepository personRepository;
    private Salary salary;

    @Override
    public void init() throws ServletException {
        personRepository = PersonRepositoryInMemory.getInstance();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<Integer, Person> people = personRepository.findAll();
        Map<Integer, Teacher> teachers = filterTeacher(people);
        String id = req.getParameter("id");
        Teacher teacher = teachers.get(Integer.parseInt(id));
        req.setAttribute("teachers", teachers);
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/aver.jsp");
        dispatcher.forward(req, resp);
    }

    private double averSal(Teacher teacher) {
        double s;
     s = salary.averageSalary(teacher.getSalary());
        return s;
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
