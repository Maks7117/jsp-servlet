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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/delete")
public class DeleteTeacher extends HttpServlet {

    private Map<Integer,Person> people;
    private PersonRepository personRepository;

    @Override
    public void init() throws ServletException {
        personRepository = PersonRepositoryInMemory.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<Integer, Person> people = personRepository.findAll();
        Map<Integer, Teacher> teachers = filterTeacher(people);
        Teacher teacher = teachers.remove(Integer.valueOf(req.getParameter("id")));
        personRepository.delete(teacher);
        resp.sendRedirect(req.getContextPath() + "/show");
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
