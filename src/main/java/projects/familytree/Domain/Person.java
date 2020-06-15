package projects.familytree.Domain;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
    @Setter private List<Person> childrenIfFather;
    @OneToMany(mappedBy = "mother")
    @Setter private List<Person> childrenIfMother;

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
    @JsonGetter("children")
    public List<Person> getChildren(){
        System.out.println(gender);
        System.out.println("122222222222222222222 "+childrenIfFather);
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$44 "+childrenIfMother);
        return gender == Gender.Эмэгтэй ? childrenIfMother : childrenIfFather;
    }
}
