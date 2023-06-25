package entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "online_payment", schema = "public", catalog = "leductha")
public class OnlinePaymentEntity {
    @Basic
    @Column(name = "card_expiration_date")
    private Date cardExpirationDate;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "debit_card_number")
    private int debitCardNumber;

    public Date getCardExpirationDate() {
        return cardExpirationDate;
    }

    public void setCardExpirationDate(Date cardExpirationDate) {
        this.cardExpirationDate = cardExpirationDate;
    }

    public int getDebitCardNumber() {
        return debitCardNumber;
    }

    public void setDebitCardNumber(int debitCardNumber) {
        this.debitCardNumber = debitCardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OnlinePaymentEntity that = (OnlinePaymentEntity) o;
        return debitCardNumber == that.debitCardNumber && Objects.equals(cardExpirationDate, that.cardExpirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardExpirationDate, debitCardNumber);
    }
}
