package by.sheremet.repository;

import by.sheremet.modele.Administration;
import by.sheremet.modele.Person;
import by.sheremet.modele.Student;
import by.sheremet.modele.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PersonRepositoryInMemory implements PersonRepository {
    private static volatile PersonRepositoryInMemory instance;
    private static int PEOPLE_COUNT;
    private Map<Integer, Person> list;
    private List<Person> people;
    private List<Integer> mark;
    // private List<Integer> averSalary;

    private PersonRepositoryInMemory(){
        list = new ConcurrentHashMap<>();
        for(Person person : initModel()){
            list.put(person.getId(), person);
        }
    }

    public static PersonRepositoryInMemory getInstance(){
        if(instance == null){
            synchronized (PersonRepositoryInMemory.class){
                if (instance == null){
                    instance = new  PersonRepositoryInMemory();
                }
            }
        }
        return instance;
    }



    public List<Person> initModel () {
        people = new ArrayList<>();
        people.add(new Teacher(++PEOPLE_COUNT, "Bil", 28, "tom", "123", List.of(125,100,358)));
        people.add(new Teacher(++PEOPLE_COUNT, "Bob", 38, "pom", "147", List.of(145,205,145)));
        people.add(new Teacher(++PEOPLE_COUNT, "Mike", 31, "ois", "578", List.of(210,300,100)));
        people.add(new Student(++PEOPLE_COUNT, "Nicole", 19, "sam", "qw", new ArrayList<>()));
        people.add(new Student(++PEOPLE_COUNT, "John", 21, "teg", "5478", new ArrayList<>()));
        people.add(new Teacher(++PEOPLE_COUNT, "Maks",32,"qwerty","qwerty", List.of(140,90,310)));
        people.add(new Administration(++PEOPLE_COUNT, "Sandra",37,"java", "san"));
        return people;

    }

    @Override
    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        list.put(person.getId(), person);
    }

    @Override
    public void delete(Person person) {
        list.remove(person.getId());
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).
                findAny().orElse(null);
    }

    @Override
    public Map<Integer, Person> findAll() {
        return new ConcurrentHashMap<>(list);
    }
}
