package com.limsa.log.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.limsa.log.domain.Student;

@Repository
public interface DemoRepository extends JpaRepository<Student, Long> {

}
