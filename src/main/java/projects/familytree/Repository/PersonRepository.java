package projects.familytree.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projects.familytree.Domain.Person;
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
