package com.datg.Greene_Daphne_DATG_CaseStudy.controller;

import com.datg.Greene_Daphne_DATG_CaseStudy.dto.TourDateDto;
import com.datg.Greene_Daphne_DATG_CaseStudy.dto.UserRegistrationDto;
import com.datg.Greene_Daphne_DATG_CaseStudy.entity.TourDate;
import com.datg.Greene_Daphne_DATG_CaseStudy.repository.TourDateRepository;
import com.datg.Greene_Daphne_DATG_CaseStudy.service.TourDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class TourDateController {
    @Autowired
    private TourDateRepository tourDateRepository;

    @Autowired
    private TourDateService tourDateService;

    @GetMapping("/tour_dates.json")
    public ResponseEntity tourDates() {
        return new ResponseEntity<Iterable<TourDate>>(tourDateRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/tour")
    public String tour() {
        return "tour";
    }

    @GetMapping("/tour_date")
    public String tour(Model model) {
        model.addAttribute("tourDate", new TourDateDto());
        return "tour_date";
    }

    @PostMapping("/tour_date")
    public String postTourDate(@ModelAttribute("tourDate") @Valid TourDateDto tourDateDto, BindingResult result) {
        if (result.hasErrors()){
            return "tour_date";
        }

        tourDateService.save(tourDateDto);
        return "redirect:/tour";
    }

    @DeleteMapping("/tour_date/{id}")
    public String deleteTourDate(@PathVariable Long id) {
        tourDateService.deleteById(id);
        return "redirect:/tour";
    }

    @GetMapping("/tour_date/{id}")
    public String editTourDate(Model model, @PathVariable Long id) {
        TourDate tourDate = tourDateRepository.getReferenceById(id);
        model.addAttribute("tourDate", tourDate);
        return "edit_tour_date";
    }

    @PostMapping("/tour_date/{id}")
    public String updateTourDate(@PathVariable Long id, @ModelAttribute("tourDate") @Valid TourDateDto tourDateDto, BindingResult result) {
        if (result.hasErrors()){
            return "tour_date";
        }

        tourDateService.update(id, tourDateDto);
        return "redirect:/tour";
    }
}
