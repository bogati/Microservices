package com.jump.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jump.model.JobCard;

@Repository
public interface JobCardRepository extends JpaRepository<JobCard,Integer>{

}
 