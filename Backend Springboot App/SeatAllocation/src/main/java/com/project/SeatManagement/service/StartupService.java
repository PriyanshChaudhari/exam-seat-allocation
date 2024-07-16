package com.project.SeatManagement.service;

import com.project.SeatManagement.repository.CenterRepository;
import com.project.SeatManagement.repository.DistrictRepository;
import com.project.SeatManagement.util.CentreUtil;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StartupService {

    @Autowired
    private AllocationService allocationService;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private CenterRepository centerRepository;

    @PostConstruct
    public void initialize() {
        //CentreUtil.saveDistrictsFromJson(districtRepository);
        //CentreUtil.addCentersForDistricts(districtRepository,centerRepository);

        //allocationService.assignDistrictAndCenterForAll();
    }
}
