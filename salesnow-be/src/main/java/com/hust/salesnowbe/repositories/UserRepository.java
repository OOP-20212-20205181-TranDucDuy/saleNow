package com.hust.salesnowbe.repositories;

import com.hust.salesnowbe.models.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>  {

    @Query("select u from UserEntity u where u.phone = :phone and u.workStatus = 'WORKING'")
    Optional<UserEntity> findByPhone(@Param("phone") String phone);

    Boolean existsByPhone(String phone);

    @Query(value = "select u from UserEntity u where (u.fullName like %:search% or u.phone like %:search%)" +
            " order by u.updatedAt desc")
    Page<UserEntity> getAllStaffs(@Param("search") String search, Pageable paging);
}
