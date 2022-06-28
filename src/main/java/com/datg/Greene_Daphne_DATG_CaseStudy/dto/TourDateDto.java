package com.datg.Greene_Daphne_DATG_CaseStudy.dto;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class TourDateDto {
    @NotEmpty(message = "City is required.")
    private String city;

    @NotEmpty(message = "Venue is required.")
    private String venue;

    @NotEmpty(message = "Date is required.")
    private String date;

    @NotEmpty(message = "Preorder is required.")
    private String preorder;

    @NotEmpty(message = "Door is required.")
    private String door;

    @NotEmpty(message = "Link is required.")
    private String link;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPreorder() {
        return preorder;
    }

    public void setPreorder(String preorder) {
        this.preorder = preorder;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
