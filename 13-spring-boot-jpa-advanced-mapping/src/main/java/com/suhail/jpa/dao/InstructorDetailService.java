package com.suhail.jpa.dao;

import com.suhail.jpa.entity.InstructorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstructorDetailService {
    private InstructorDetailRepository instructorDetailRepository;

    @Autowired
    public InstructorDetailService(InstructorDetailRepository instructorDetailRepository){
        this.instructorDetailRepository = instructorDetailRepository;
    }

    public InstructorDetail findById(int id){
        Optional<InstructorDetail> instructorDetail = instructorDetailRepository.findById(id);
        return instructorDetail.get();
    }

    public void deleteInstructorDetailById(int id){
        InstructorDetail instructorDetail = findById(id);
        instructorDetail.getInstructor().setInstructorDetail(null);
        instructorDetailRepository.delete(instructorDetail);
    }
}
