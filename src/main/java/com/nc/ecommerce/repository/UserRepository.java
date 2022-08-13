package com.nc.ecommerce.repository;

import com.nc.ecommerce.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
