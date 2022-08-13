package com.nc.ecommerce.auth.model;

import com.nc.ecommerce.model.Order;
import com.nc.ecommerce.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message="{error.empty_field}")
    @Column(nullable = false, updatable = true)
    private String firstName;

    @NotNull(message="{error.empty_field}")
    @Column(nullable = false, updatable = true)
    private String lastName;

    @NotNull(message="{error.empty_field}")
    @Column(nullable = false, updatable = true, unique = true)
    private String email;

    @NotNull(message="{error.empty_field}")
    @Column(nullable = false, updatable = true)
    private String password;

    @NotNull
    @Column(nullable = true, updatable = true)
    private String photo;

  /*  @OneToOne
    @JoinColumn(name="role")
    private Role role;
*/
    @Column(columnDefinition = "boolean default false")
    private final boolean deleted = Boolean.FALSE;

    @CreationTimestamp
    @Column(name="create_at")
    private LocalDate created;

    @UpdateTimestamp
    @Column(name="updated_at")
    private LocalDate updated;

    @OneToMany(mappedBy = "user")
    private List<Product> products;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;



//    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    @JoinTable(name = "user_role",
//            joinColumns=@JoinColumn(name="users_id"),
//            inverseJoinColumns=@JoinColumn(name="roles_id"))
//    private Set<Role> roles = new HashSet<>();
//
//    public Set<Role> getRoles() {
//        return roles;
//    }
}
