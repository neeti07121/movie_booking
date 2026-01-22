package com.movie.booking.movieBooking.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalTime;

@Getter
@Setter
public class UpdateShowRequestDTO {

    private LocalTime startTime;
    private LocalTime endTime;
    private BigDecimal basePrice;
}
