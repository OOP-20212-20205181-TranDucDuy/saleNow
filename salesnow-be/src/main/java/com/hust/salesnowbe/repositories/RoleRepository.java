package com.hust.salesnowbe.repositories;


import com.hust.salesnowbe.models.Role;
import com.hust.salesnowbe.models.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query("select r from Role r where r.name = :name")
    Optional<Role> findByName(@Param("name") RoleType name);
}