package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "address", schema = "public", catalog = "leductha")
public class AddressEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "person_id")
    private int personId;

    @OneToOne
    @JoinColumn(name = "person_id")
    private PersonalInformationEntity personalInformation;

    @Basic
    @Column(name = "country")
    private String country;
    @Basic
    @Column(name = "street")
    private String street;
    @Basic
    @Column(name = "zipcode")
    private int zipcode;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressEntity that = (AddressEntity) o;
        return personId == that.personId && zipcode == that.zipcode && Objects.equals(country, that.country) && Objects.equals(street, that.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, country, street, zipcode);
    }
}
