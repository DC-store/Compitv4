package com.CompitApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CompitApplication.Model.Roles;

@Repository
public interface RoleRepo extends JpaRepository<Roles, Integer> {

}
