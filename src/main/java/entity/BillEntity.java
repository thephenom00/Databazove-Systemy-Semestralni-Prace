package entity;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "bill", schema = "public", catalog = "leductha")
public class BillEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "bill_id")
    private int billId;
    @Basic
    @Column(name = "bill_time")
    private Time billTime;
    @Basic
    @Column(name = "bill_cost")
    private int billCost;
    @OneToMany(mappedBy = "billByBillId")
    private Collection<OrdersEntity> ordersByBillId;

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public Time getBillTime() {
        return billTime;
    }

    public void setBillTime(Time billTime) {
        this.billTime = billTime;
    }

    public int getBillCost() {
        return billCost;
    }

    public void setBillCost(int billCost) {
        this.billCost = billCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillEntity that = (BillEntity) o;
        return billId == that.billId && billCost == that.billCost && Objects.equals(billTime, that.billTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billId, billTime, billCost);
    }

    public Collection<OrdersEntity> getOrdersByBillId() {
        return ordersByBillId;
    }

    public void setOrdersByBillId(Collection<OrdersEntity> ordersByBillId) {
        this.ordersByBillId = ordersByBillId;
    }
}
