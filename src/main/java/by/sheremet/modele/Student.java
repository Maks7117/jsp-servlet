package by.sheremet.modele;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    private List<Integer> marks;

    {
        marks = new ArrayList<>();
    }

    public Student(){
    }

    public Student(int id, String name, int age, String login, String password, List<Integer> marks) {
        super(id, name, age, login, password);
        this.marks = marks;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "marks=" + marks +
                '}';
    }
}
