package projects.familytree.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import projects.familytree.Domain.Person;
import projects.familytree.Service.PersonService;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping("/persons")
    public List<Person> getAllPerson(){
     return personService.getAllPerson();
    }
    @PostMapping("/newPerson")
    public Person addPerson(@RequestBody Person person){
        return personService.addPerson(person);
    }
}
