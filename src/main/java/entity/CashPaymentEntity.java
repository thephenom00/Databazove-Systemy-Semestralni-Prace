package entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "cash_payment", schema = "public", catalog = "leductha")
public class CashPaymentEntity {
    @Basic
    @Column(name = "cash_payment_date")
    private Date cashPaymentDate;
    @Basic
    @Column(name = "cas_payment_status")
    private String casPaymentStatus;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "bank_note_serial_number")
    private int bankNoteSerialNumber;

    public Date getCashPaymentDate() {
        return cashPaymentDate;
    }

    public void setCashPaymentDate(Date cashPaymentDate) {
        this.cashPaymentDate = cashPaymentDate;
    }

    public String getCasPaymentStatus() {
        return casPaymentStatus;
    }

    public void setCasPaymentStatus(String casPaymentStatus) {
        this.casPaymentStatus = casPaymentStatus;
    }

    public int getBankNoteSerialNumber() {
        return bankNoteSerialNumber;
    }

    public void setBankNoteSerialNumber(int bankNoteSerialNumber) {
        this.bankNoteSerialNumber = bankNoteSerialNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CashPaymentEntity that = (CashPaymentEntity) o;
        return bankNoteSerialNumber == that.bankNoteSerialNumber && Objects.equals(cashPaymentDate, that.cashPaymentDate) && Objects.equals(casPaymentStatus, that.casPaymentStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cashPaymentDate, casPaymentStatus, bankNoteSerialNumber);
    }
}
