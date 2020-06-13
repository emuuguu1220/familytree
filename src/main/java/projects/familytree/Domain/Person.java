package projects.familytree.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;

@Entity
public @Data class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date DOB;
    private String firstName;
    private String lastName;
    private String familyName;
    @JsonIgnore
    @OneToMany(mappedBy = "father")
    private List<Person> childrenIfFather;
    @JsonIgnore
    @OneToMany(mappedBy = "mother")
    private List<Person> childrenIfMother;

    @ManyToMany
    private List<Person> spouses;

    @ManyToOne
    private Person father;
    @ManyToOne
    private Person mother;
    private Gender gender;
    private String phoneNumber;
    private String other;
    private String maritalStatus;
    private Date DOD;
    @Email
    private String email;
    public List<Person> getChildren(){
        return gender == Gender.Эмэгтэй ? childrenIfMother : childrenIfFather;
    }
}
