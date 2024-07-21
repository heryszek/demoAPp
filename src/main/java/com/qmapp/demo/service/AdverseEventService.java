package com.qmapp.demo.service;


import com.qmapp.demo.model.AdverseEvent;
import com.qmapp.demo.repository.AdverseEventRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdverseEventService {


    private final AdverseEventRepository adverseEventRepository;

    @Autowired
    public AdverseEventService(AdverseEventRepository adverseEventRepository) {
        this.adverseEventRepository = adverseEventRepository;
    }


    public List<AdverseEvent> getAllAdverseEvents() {
        return adverseEventRepository.findAll();
    }

    public AdverseEvent saveAdverseEvent(AdverseEvent adverseEvent) {
        return adverseEventRepository.save(adverseEvent);
    }

    public void deleteAdverseEvent(Long id) {
        adverseEventRepository.deleteById(id);
    }
}

