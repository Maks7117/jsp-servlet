package by.sheremet.repository;

import by.sheremet.modele.Person;

import java.util.List;
import java.util.Map;

public interface PersonRepository {
    void save (Person person);
    void delete (Person person);

    Person show(int id);

    Map<Integer, Person> findAll();
}
