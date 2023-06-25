package entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "product", schema = "public", catalog = "leductha")
public class ProductEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id")
    private int productId;
    @Basic
    @Column(name = "price")
    private int price;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(insertable=false, updatable=false, name = "category_name")
    private int categoryName;
    @Basic
    @Column(name = "product_count")
    private Integer productCount;
    @OneToMany(mappedBy = "productByProductId")
    private Collection<CartEntity> cartsByProductId;
    @ManyToOne
    @JoinColumn(name = "category_name", referencedColumnName = "category_id", nullable = false)
    private CategoryEntity categoryByCategoryName;
    @OneToMany(mappedBy = "productByProductId")
    private Collection<WishListEntity> wishListsByProductId;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(int categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return productId == that.productId && price == that.price && categoryName == that.categoryName && Objects.equals(description, that.description) && Objects.equals(productCount, that.productCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, price, description, categoryName, productCount);
    }

    public Collection<CartEntity> getCartsByProductId() {
        return cartsByProductId;
    }

    public void setCartsByProductId(Collection<CartEntity> cartsByProductId) {
        this.cartsByProductId = cartsByProductId;
    }

    public CategoryEntity getCategoryByCategoryName() {
        return categoryByCategoryName;
    }

    public void setCategoryByCategoryName(CategoryEntity categoryByCategoryName) {
        this.categoryByCategoryName = categoryByCategoryName;
    }

    public Collection<WishListEntity> getWishListsByProductId() {
        return wishListsByProductId;
    }

    public void setWishListsByProductId(Collection<WishListEntity> wishListsByProductId) {
        this.wishListsByProductId = wishListsByProductId;
    }
}
