package entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "coupon", schema = "public", catalog = "leductha")
public class CouponEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "coupon_code")
    private int couponCode;
    @Basic
    @Column(name = "expiration")
    private Date expiration;
    @Basic
    @Column(name = "discount")
    private Integer discount;

    public int getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(int couponCode) {
        this.couponCode = couponCode;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CouponEntity that = (CouponEntity) o;
        return couponCode == that.couponCode && Objects.equals(expiration, that.expiration) && Objects.equals(discount, that.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(couponCode, expiration, discount);
    }
}
