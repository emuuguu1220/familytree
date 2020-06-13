package projects.familytree.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    @GetMapping("/persons/{ID}")
    public Person getPerson(@PathVariable long ID){
        System.out.println("&&&&&&&&&&&&&&$$################# "+ID);
        return personService.getPerson(ID);
    }
    @PostMapping("/newPerson")
    public Person addPerson(@RequestBody Person person){
        return personService.addPerson(person);
    }
}
