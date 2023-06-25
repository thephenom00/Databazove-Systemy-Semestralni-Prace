package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "employee", schema = "public", catalog = "leductha")
public class EmployeeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "person_id")
    private int personId;

    @OneToOne
    @JoinColumn(name = "person_id")
    private PersonalInformationEntity personalInformation;

    @Column(name = "supervisor")
    private Integer supervisor;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public Integer getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Integer supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return personId == that.personId && Objects.equals(supervisor, that.supervisor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, supervisor);
    }
}
