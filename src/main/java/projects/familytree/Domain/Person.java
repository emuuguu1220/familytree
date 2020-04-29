package projects.familytree.Domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue
    @Getter
    private int id;
    @Getter
    @Setter
    private Date DOB;
    @Getter
    @Setter
    private String firstName;
    @Getter
    @Setter
    private String lastName;
    @Getter
    @Setter
    private String familyName;
    @Getter
    @Setter
    @OneToMany
    private List<Person> children;
    @Getter
    @Setter
    @ManyToMany
    private List<Person> spouses;
    @Getter
    @Setter
    @ManyToOne
    private Person father;
    @Getter
    @Setter
    @ManyToOne
    private Person mother;
    @Getter
    @Setter
    private Gender gender;
    @Getter
    @Setter
    private String phoneNumber;
    @Getter
    @Setter
    private String other;

}
