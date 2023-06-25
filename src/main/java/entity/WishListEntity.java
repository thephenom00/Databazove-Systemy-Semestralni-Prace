package entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "wish_list", schema = "public", catalog = "leductha")
public class WishListEntity {
    @Basic
    @Column(name = "wish_list_quantity")
    private int wishListQuantity;
    @Basic
    @Column(name = "wish_list_date")
    private Date wishListDate;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "wish_list_id")
    private int wishListId;
    @Basic
    @Column(insertable=false, updatable=false, name = "product_id")
    private int productId;

    @OneToMany(mappedBy = "wishListByWishListId")
    private Collection<CustomerEntity> customersByWishListId;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    private ProductEntity productByProductId;

    public int getWishListQuantity() {
        return wishListQuantity;
    }

    public void setWishListQuantity(int wishListQuantity) {
        this.wishListQuantity = wishListQuantity;
    }

    public Date getWishListDate() {
        return wishListDate;
    }

    public void setWishListDate(Date wishListDate) {
        this.wishListDate = wishListDate;
    }

    public int getWishListId() {
        return wishListId;
    }

    public void setWishListId(int wishListId) {
        this.wishListId = wishListId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WishListEntity that = (WishListEntity) o;
        return wishListQuantity == that.wishListQuantity && wishListId == that.wishListId && productId == that.productId && Objects.equals(wishListDate, that.wishListDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wishListQuantity, wishListDate, wishListId, productId);
    }

    public Collection<CustomerEntity> getCustomersByWishListId() {
        return customersByWishListId;
    }

    public void setCustomersByWishListId(Collection<CustomerEntity> customersByWishListId) {
        this.customersByWishListId = customersByWishListId;
    }

    public ProductEntity getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(ProductEntity productByProductId) {
        this.productByProductId = productByProductId;
    }
}
