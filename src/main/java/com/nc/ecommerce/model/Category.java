package com.nc.ecommerce.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "{error.empty_field}")
    private String name;

    @CreationTimestamp
    @Column(name="create_at")
    private LocalDate create;

    @UpdateTimestamp
    @Column(name="updated_at")
    private LocalDate update;

    private boolean deleted;
}
