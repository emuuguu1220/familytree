package projects.familytree.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projects.familytree.Domain.Person;
import projects.familytree.Repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public List<Person> getAllPerson(){
        return personRepository.findAll();
    }

    public Person getPerson(long ID){
        return personRepository.getOne(ID);
    }

    public Person addPerson(Person person){
            return personRepository.save(person);
    }
}
