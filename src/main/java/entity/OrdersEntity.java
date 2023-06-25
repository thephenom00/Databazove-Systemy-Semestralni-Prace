package entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "orders", schema = "public", catalog = "leductha")
public class OrdersEntity {
    @EmbeddedId
    private OrdersID id;
    @Basic
    @Column(name = "order_time")
    private Time orderTime;
    @Basic
    @Column(name = "order_status")
    private String orderStatus;
    @Basic
    @Column(name = "order_date")
    private Date orderDate;
    @Basic
    @Column(name = "employee_id")
    private Integer employeeId;
    @Basic
    @Column(name = "bill_id", insertable=false, updatable=false)
    private int billId;
    @Basic
    @Column(name = "coupon_code")
    private Integer couponCode;
    @Basic
    @Column(name = "payment_id")
    private int paymentId;
    @Basic
    @Column(name = "cart_number", insertable=false, updatable=false)
    private Integer cartNumber;
    @ManyToOne
    @JoinColumn(name = "bill_id", referencedColumnName = "bill_id", nullable = false)
    private BillEntity billByBillId;
    @ManyToOne
    @JoinColumn(name = "cart_number", referencedColumnName = "cart_number")
    private CartEntity cartByCartNumber;

    public Time getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Time orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public Integer getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(Integer couponCode) {
        this.couponCode = couponCode;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(Integer cartNumber) {
        this.cartNumber = cartNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersEntity that = (OrdersEntity) o;
        return billId == that.billId && paymentId == that.paymentId && Objects.equals(orderTime, that.orderTime) && Objects.equals(orderStatus, that.orderStatus) && Objects.equals(orderDate, that.orderDate) && Objects.equals(employeeId, that.employeeId) && Objects.equals(couponCode, that.couponCode) && Objects.equals(cartNumber, that.cartNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderTime, orderStatus, orderDate, employeeId, billId, couponCode, paymentId, cartNumber);
    }

    public BillEntity getBillByBillId() {
        return billByBillId;
    }

    public void setBillByBillId(BillEntity billByBillId) {
        this.billByBillId = billByBillId;
    }

    public CartEntity getCartByCartNumber() {
        return cartByCartNumber;
    }

    public void setCartByCartNumber(CartEntity cartByCartNumber) {
        this.cartByCartNumber = cartByCartNumber;
    }
}
