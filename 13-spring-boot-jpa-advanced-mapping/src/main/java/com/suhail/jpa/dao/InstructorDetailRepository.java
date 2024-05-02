package com.suhail.jpa.dao;

import com.suhail.jpa.entity.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorDetailRepository extends JpaRepository<InstructorDetail, Integer> {
}
