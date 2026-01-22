package com.movie.booking.movieBooking.service;

import com.movie.booking.movieBooking.dto.ShowResponseDTO;
import com.movie.booking.movieBooking.dto.TheatreShowResponseDTO;
import com.movie.booking.movieBooking.model.MovieShow;
import com.movie.booking.movieBooking.repository.MovieShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BrowseShowService {

    private final MovieShowRepository movieShowRepository;

    public List<TheatreShowResponseDTO> browseShows(
            Long movieId,
            Long cityId,
            LocalDate showDate) {

        List<MovieShow> shows =
                movieShowRepository.findShows(movieId, cityId, showDate);

        Map<String, TheatreShowResponseDTO> responseMap = new HashMap<>();

        for (MovieShow show : shows) {
            String theatreName = show.getScreen().getTheatre().getName();

            responseMap.putIfAbsent(theatreName, new TheatreShowResponseDTO());
            TheatreShowResponseDTO dto = responseMap.get(theatreName);
            dto.setTheatreName(theatreName);

            dto.getShows().add(
                    new ShowResponseDTO(
                            show.getScreen().getName(),
                            show.getScreen().getName(),
                            show.getStartTime(),
                            show.getEndTime(),
                            show.getBasePrice()
                    )
            );
        }

        return new ArrayList<>(responseMap.values());
    }
}
