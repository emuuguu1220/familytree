package projects.familytree.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projects.familytree.Domain.Person;
import projects.familytree.Service.PersonService;

import java.util.List;

@RestController
@CrossOrigin
public class PersonController {
    @Autowired
    PersonService personService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);
    @GetMapping("/persons")
    public List<Person> getAllPerson(){
        LOGGER.info("Inside getAllPerson");
     return personService.getAllPerson();
    }
    @GetMapping("/persons/{ID}")
    public Person getPerson(@PathVariable long ID){
        return personService.getPerson(ID);
    }
    @PostMapping("/newPerson")
    public Person addPerson(@RequestBody Person person){
        return personService.addPerson(person);
    }

}
