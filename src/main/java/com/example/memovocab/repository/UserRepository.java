package com.example.memovocab.repository;

import com.example.memovocab.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>, ListPagingAndSortingRepository<User, Integer> {
    List<User> findAll();

    Page<User> findAll(Pageable pageable);
}
