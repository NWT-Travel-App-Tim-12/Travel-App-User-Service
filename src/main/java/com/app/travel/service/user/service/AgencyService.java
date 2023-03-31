package com.app.travel.service.user.service;

import com.app.travel.service.user.model.entity.Agency;
import com.app.travel.service.user.repository.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AgencyService {
    @Autowired
    private AgencyRepository agencyRepository;

    public Agency addAgency(Agency agency) {
        return agencyRepository.save(agency);
    }
}
