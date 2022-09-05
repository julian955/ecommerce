package com.nc.ecommerce.model;

import com.nc.ecommerce.auth.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "{error.empty_field}")
    private String number;

    @CreationTimestamp
    @Column(name="create_at")
    private LocalDate created;

    @UpdateTimestamp
    @Column(name="updated_at")
    private LocalDate updated;

    private LocalDate recived;

    private Double total;

    @ManyToOne
    private User user;

    @OneToOne(mappedBy = "order")
    private OrderDetail orderDetail;
}
