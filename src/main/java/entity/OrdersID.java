package entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class OrdersID implements Serializable {
    private Long billId;
    private Long employeeId;

}