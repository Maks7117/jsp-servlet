package by.sheremet.modele;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {
    private List<Integer> salary;

    {
        salary = new ArrayList<>();
    }

    public Teacher(){
    }
    public Teacher(int id, String name, int age, String login, String password, List<Integer> salary) {
        super(id, name, age, login, password);
        this.salary = salary;
    }

    public Teacher(String name, int age, List<Integer> salary) {
        super(name, age);
        this.salary = salary;
    }

    public List<Integer> getSalary() {
        return salary;
    }

    public void setSalary(List<Integer> salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "salary=" + salary +
                '}';
    }
}
