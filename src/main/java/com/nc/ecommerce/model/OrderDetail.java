package com.nc.ecommerce.model;

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
@Table(name = "order_detail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "{error.empty_field}")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "{error.empty_field}")
    private Double quantity;

    @Column(nullable = false)
    @NotNull(message = "{error.empty_field}")
    private Double price;

    @Column(nullable = false)
    @NotNull(message = "{error.empty_field}")
    private Double total;

    @CreationTimestamp
    @Column(name="create_at")
    private LocalDate created;

    @UpdateTimestamp
    @Column(name="updated_at")
    private LocalDate updated;

    @OneToOne
    private Order order;

    @ManyToOne
    private Product product;
}
