package entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "cart", schema = "public", catalog = "leductha")
public class CartEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cart_number")
    private int cartNumber;
    @Basic
    @Column(name = "cart_quantity")
    private int cartQuantity;
    @Basic
    @Column(insertable=false, updatable=false, name = "product_id")
    private int productId;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    private ProductEntity productByProductId;
    @OneToMany(mappedBy = "cartByCartNumber")
    private Collection<CustomerEntity> customersByCartNumber;
    @OneToMany(mappedBy = "cartByCartNumber")
    private Collection<OrdersEntity> ordersByCartNumber;

    public int getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(int cartNumber) {
        this.cartNumber = cartNumber;
    }

    public int getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(int cartQuantity) {
        this.cartQuantity = cartQuantity;
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
        CartEntity that = (CartEntity) o;
        return cartNumber == that.cartNumber && cartQuantity == that.cartQuantity && productId == that.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartNumber, cartQuantity, productId);
    }

    public ProductEntity getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(ProductEntity productByProductId) {
        this.productByProductId = productByProductId;
    }

    public Collection<CustomerEntity> getCustomersByCartNumber() {
        return customersByCartNumber;
    }

    public void setCustomersByCartNumber(Collection<CustomerEntity> customersByCartNumber) {
        this.customersByCartNumber = customersByCartNumber;
    }

    public Collection<OrdersEntity> getOrdersByCartNumber() {
        return ordersByCartNumber;
    }

    public void setOrdersByCartNumber(Collection<OrdersEntity> ordersByCartNumber) {
        this.ordersByCartNumber = ordersByCartNumber;
    }
}
