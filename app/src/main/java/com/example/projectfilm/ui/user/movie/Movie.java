package com.example.projectfilm.ui.user.movie;

import java.io.Serializable;

public class Movie implements Serializable {
    private String title;
    private String imageUrl;
    private String description;
    private String genre;
    private String status;
    private String ticketPrice;
    public String getTicketPrice() {
        return ticketPrice;
    }

    public Movie() {
        // Constructor rỗng bắt buộc cho Firestore
    }

    public Movie(String title, String imageUrl, String description, String genre, String status) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.description = description;
        this.genre = genre;
        this.status = status;
    }
    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getTitle() { return title; }
    public String getImageUrl() { return imageUrl; }
    public String getDescription() { return description; }
    public String getGenre() { return genre; }
    public String getStatus() { return status; }
}
