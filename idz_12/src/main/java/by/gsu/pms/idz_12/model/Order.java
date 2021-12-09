package by.gsu.pms.idz_12.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private LocalDateTime deadline;
    private LocalDateTime deliveryTime;
    private String content;
    private String deliveryman;
    private OrderState state;

    public Order() {
    }

    public Order(Long id, String name, String address, LocalDateTime deadline, LocalDateTime deliveryTime, String content, String deliveryman, OrderState state) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.deadline = deadline;
        this.deliveryTime = deliveryTime;
        this.content = content;
        this.deliveryman = deliveryman;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDeliveryman() {
        return deliveryman;
    }

    public void setDeliveryman(String deliveryman) {
        this.deliveryman = deliveryman;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
