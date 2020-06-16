package projects.familytree.Domain;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import projects.familytree.DTO.Spouse;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
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

//
//    @ManyToMany
//    @Getter @Setter private List<Person> spouses;



    //================


//
     @Setter
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name="person1_person2",
        joinColumns={@JoinColumn(name="person1_id")},
        inverseJoinColumns={@JoinColumn(name="person2_id")})
    private List<Person> person1;

    @Setter
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //@ManyToMany(mappedBy="person1")
    @ManyToMany(mappedBy="person1", cascade={CascadeType.ALL})
    private List<Person> person2;

    @JsonGetter("spouses")
    public List<Person> getSpouses(){
        List<Person> result = new ArrayList<>();
        System.out.println("@@@@@@@@@@@@");
        //System.out.println("@@@@@@@@@@@@"+this.spouses+ " "+ spouses.size());
        if(this.person1 != null){
        for (Person p: this.person1){

            Person person = new Person(p.id, p.DOB,p.firstName,p.lastName,p.familyName,p.childrenIfFather,p.childrenIfMother,null,null,p.father,p.mother,p.gender,p.phoneNumber,p.other,p.maritalStatus,p.DOD,p.email);
//            person.childrenIfFather.removeAll(this.childrenIfFather);
//            person.childrenIfMother.removeAll(this.childrenIfMother);
            result.add(person);
            }
        }
        if(this.person2 != null){
            for (Person p: this.person2){
                Person person = new Person(p.id, p.DOB,p.firstName,p.lastName,p.familyName,p.childrenIfFather,p.childrenIfMother,null,null,p.father,p.mother,p.gender,p.phoneNumber,p.other,p.maritalStatus,p.DOD,p.email);
//                person.childrenIfFather.removeAll(this.childrenIfFather);
//                person.childrenIfMother.removeAll(this.childrenIfMother);
                result.add(person);
            }
        }
        return result;
    }

//   @JsonGetter("spouses")
//    private List<Person> getSpouses(){
////        List<Person> result = new ArrayList<>();
////        //System.out.println("@@@@@@@@@@@@"+this.spouses+ " "+ spouses.size());
////        for (Person p: this.person1){
////            Person person = new Person(p.id, p.DOB,p.firstName,p.lastName,p.familyName,p.childrenIfFather,p.childrenIfMother,null,null,p.father,p.mother,p.gender,p.phoneNumber,p.other,p.maritalStatus,p.DOD,p.email);
////            result.add(person);
////        }
//       // return result;
//       return person2;
//    }
    //==============


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
        return gender == Gender.Эмэгтэй ? childrenIfMother : childrenIfFather;
    }


}
