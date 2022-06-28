package com.datg.Greene_Daphne_DATG_CaseStudy.service;

import com.datg.Greene_Daphne_DATG_CaseStudy.dto.TourDateDto;
import com.datg.Greene_Daphne_DATG_CaseStudy.entity.TourDate;
import com.datg.Greene_Daphne_DATG_CaseStudy.repository.TourDateRepository;
import com.datg.Greene_Daphne_DATG_CaseStudy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourDateServiceImpl implements TourDateService {
    @Autowired
    private TourDateRepository tourDateRepository;

    @Override
    public TourDate save(TourDateDto tourDateDto) {
        TourDate tourDate = new TourDate();
        tourDate.setCity(tourDateDto.getCity());
        tourDate.setVenue(tourDateDto.getVenue());
        tourDate.setDate(tourDateDto.getDate());
        tourDate.setPreorder(tourDateDto.getPreorder());
        tourDate.setDoor(tourDateDto.getDoor());
        tourDate.setLink(tourDateDto.getLink());
        return tourDateRepository.save(tourDate);
    }

    @Override
    public void deleteById(Long id) {
        tourDateRepository.deleteById(id);
    }

    @Override
    public void update(Long id, TourDateDto tourDateDto) {
        TourDate tourDate = tourDateRepository.getReferenceById(id);
        tourDate.setCity(tourDateDto.getCity());
        tourDate.setVenue(tourDateDto.getVenue());
        tourDate.setDate(tourDateDto.getDate());
        tourDate.setPreorder(tourDateDto.getPreorder());
        tourDate.setDoor(tourDateDto.getDoor());
        tourDate.setLink(tourDateDto.getLink());
        tourDateRepository.save(tourDate);
    }
}
