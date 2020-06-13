package projects.familytree.Domain;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter private long id;
    @Getter @Setter private Date DOB;
    @Getter @Setter private String firstName;
    @Getter @Setter private String lastName;
    @Getter @Setter private String familyName;
    @OneToMany(mappedBy = "father")
    @Getter @Setter private List<Person> childrenIfFather;
    @OneToMany(mappedBy = "mother")
    @Getter @Setter private List<Person> childrenIfMother;

    @ManyToMany
    @Getter @Setter private List<Person> spouses;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Person father;
    @JsonIgnore
    public Person getFather() {
        return father;
    }
    public void setFather(Person father) {
        this.father = father;
    }
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Person mother;
    @JsonIgnore
    public Person getMother() {
        return mother;
    }
    public void setMother(Person mother) {
        this.mother = mother;
    }

    @Getter @Setter private Gender gender;
    @Getter @Setter private String phoneNumber;
    @Getter @Setter private String other;
    @Getter @Setter private String maritalStatus;
    @Getter @Setter private Date DOD;
    @Email
    @Getter @Setter private String email;
//    @JsonGetter("childrenIfMother")
//    public List<Person> getChildren(){
//        return gender == Gender.Эмэгтэй ? childrenIfMother : childrenIfFather;
//    }
}
