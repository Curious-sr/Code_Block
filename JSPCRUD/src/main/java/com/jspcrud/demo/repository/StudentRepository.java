package com.jspcrud.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jspcrud.demo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
