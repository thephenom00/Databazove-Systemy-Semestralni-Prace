package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "payment", schema = "public", catalog = "leductha")
public class PaymentEntity {
    @Basic
    @Column(name = "payment_amount")
    private int paymentAmount;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "payment_id")
    private int paymentId;
    @Basic
    @Column(name = "payment_method")
    private String paymentMethod;
    @Basic
    @Column(name = "cash_payment_id")
    private Integer cashPaymentId;
    @Basic
    @Column(name = "online_payment_id")
    private Integer onlinePaymentId;

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Integer getCashPaymentId() {
        return cashPaymentId;
    }

    public void setCashPaymentId(Integer cashPaymentId) {
        this.cashPaymentId = cashPaymentId;
    }

    public Integer getOnlinePaymentId() {
        return onlinePaymentId;
    }

    public void setOnlinePaymentId(Integer onlinePaymentId) {
        this.onlinePaymentId = onlinePaymentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentEntity that = (PaymentEntity) o;
        return paymentAmount == that.paymentAmount && paymentId == that.paymentId && Objects.equals(paymentMethod, that.paymentMethod) && Objects.equals(cashPaymentId, that.cashPaymentId) && Objects.equals(onlinePaymentId, that.onlinePaymentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentAmount, paymentId, paymentMethod, cashPaymentId, onlinePaymentId);
    }
}
