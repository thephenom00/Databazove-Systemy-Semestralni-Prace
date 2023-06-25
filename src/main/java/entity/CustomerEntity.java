package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "customer", schema = "public", catalog = "leductha")
public class CustomerEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "person_id")
    private int personId;

    @OneToOne
    @JoinColumn(name = "person_id")
    private PersonalInformationEntity personalInformation;

    @Basic
    @Column(name = "cart_number", insertable=false, updatable=false)
    private int cartNumber;
    @Basic
    @Column(name = "wish_list_id", insertable=false, updatable=false)
    private int wishListId;
    @ManyToOne
    @JoinColumn(name = "cart_number", referencedColumnName = "cart_number", nullable = false)
    private CartEntity cartByCartNumber;
    @ManyToOne
    @JoinColumn(name = "wish_list_id", referencedColumnName = "wish_list_id", nullable = false)
    private WishListEntity wishListByWishListId;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(int cartNumber) {
        this.cartNumber = cartNumber;
    }

    public int getWishListId() {
        return wishListId;
    }

    public void setWishListId(int wishListId) {
        this.wishListId = wishListId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity that = (CustomerEntity) o;
        return personId == that.personId && cartNumber == that.cartNumber && wishListId == that.wishListId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, cartNumber, wishListId);
    }

    public CartEntity getCartByCartNumber() {
        return cartByCartNumber;
    }

    public void setCartByCartNumber(CartEntity cartByCartNumber) {
        this.cartByCartNumber = cartByCartNumber;
    }

    public WishListEntity getWishListByWishListId() {
        return wishListByWishListId;
    }

    public void setWishListByWishListId(WishListEntity wishListByWishListId) {
        this.wishListByWishListId = wishListByWishListId;
    }
}
