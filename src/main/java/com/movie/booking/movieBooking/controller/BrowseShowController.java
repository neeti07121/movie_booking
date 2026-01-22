package com.movie.booking.movieBooking.controller;

import com.movie.booking.movieBooking.dto.TheatreShowResponseDTO;
import com.movie.booking.movieBooking.service.BrowseShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/browse")
@RequiredArgsConstructor
public class BrowseShowController {

    private final BrowseShowService browseShowService;

    @GetMapping("/shows")
    public List<TheatreShowResponseDTO> browseShows(
            @RequestParam Long movieId,
            @RequestParam Long cityId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate showDate) {

        return browseShowService.browseShows(movieId, cityId, showDate);
    }
}
