package com.movie.booking.movieBooking.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TheatreShowResponseDTO {

    private String theatreName;
    private List<ShowResponseDTO> shows = new ArrayList<>();
}
