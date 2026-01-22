package com.movie.booking.movieBooking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
public class ShowResponseDTO {

    private String theatreName;
    private String screenName;
    private LocalTime startTime;
    private LocalTime endTime;
    private BigDecimal price;
}
