package projects.familytree.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.familytree.Domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
