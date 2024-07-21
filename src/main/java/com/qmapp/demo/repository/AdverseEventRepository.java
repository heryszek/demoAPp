package com.qmapp.demo.repository;


import com.qmapp.demo.model.AdverseEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdverseEventRepository extends JpaRepository<AdverseEvent, Long> {
}

