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
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "{error.empty_field}")
    private String name;

    private String description;

    private String image;

    @Column(nullable = false)
    @NotNull(message = "{error.empty_field}")
    private double price;

    private int quantity;

    @CreationTimestamp
    @Column(name="create_at")
    private LocalDate created;

    @UpdateTimestamp
    @Column(name="updated_at")
    private LocalDate updated;

    @ManyToOne
    private User user;

    private boolean deleted;
}
