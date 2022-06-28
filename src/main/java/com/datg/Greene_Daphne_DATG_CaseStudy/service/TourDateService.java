package com.datg.Greene_Daphne_DATG_CaseStudy.service;

import com.datg.Greene_Daphne_DATG_CaseStudy.dto.TourDateDto;
import com.datg.Greene_Daphne_DATG_CaseStudy.entity.TourDate;

public interface TourDateService {
    TourDate save(TourDateDto registration);

    void deleteById(Long id);

    void update(Long id, TourDateDto tourDateDto);
}
