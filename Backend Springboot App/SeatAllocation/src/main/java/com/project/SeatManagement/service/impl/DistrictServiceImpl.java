package com.project.SeatManagement.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.SeatManagement.entity.District;
import com.project.SeatManagement.repository.DistrictRepository;
import com.project.SeatManagement.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public void saveDistrictsFromJson() {
        ObjectMapper mapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("districts.json");
        DistrictData districtData = null;
        try {
            districtData = mapper.readValue(resource.getInputStream(), DistrictData.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String districtName : districtData.getDistricts()) {
            District district = new District();
            district.setDistrictName(districtName);
            districtRepository.save(district);
        }
    }

    private static class DistrictData {
        private List<String> districts;

        public List<String> getDistricts() {
            return districts;
        }

        public void setDistricts(List<String> districts) {
            this.districts = districts;
        }
    }
}