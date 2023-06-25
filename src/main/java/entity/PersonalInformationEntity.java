package entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table (name= "personal_information", schema = "public", catalog = "leductha")

public class PersonalInformationEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "person_id")
    private int personId;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "firstname")
    private String firstname;
    @Basic
    @Column(name = "lastname")
    private String lastname;
    @Basic
    @Column(name = "birthday")
    private Date birthday;

    @OneToOne(mappedBy = "personalInformation", cascade = CascadeType.ALL)
    private EmployeeEntity employee;

    @OneToOne(mappedBy = "personalInformation", cascade = CascadeType.ALL)
    private AddressEntity address;

    @OneToOne(mappedBy = "personalInformation", cascade = CascadeType.ALL)
    private CustomerEntity customer;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalInformationEntity that = (PersonalInformationEntity) o;
        return personId == that.personId && Objects.equals(email, that.email) && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(birthday, that.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, email, firstname, lastname, birthday);
    }
}
