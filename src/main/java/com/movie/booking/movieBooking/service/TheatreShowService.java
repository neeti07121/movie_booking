package com.movie.booking.movieBooking.service;

import com.movie.booking.movieBooking.dto.CreateShowRequestDTO;
import com.movie.booking.movieBooking.dto.UpdateShowRequestDTO;
import com.movie.booking.movieBooking.model.Movie;
import com.movie.booking.movieBooking.model.MovieShow;
import com.movie.booking.movieBooking.model.Screen;
import com.movie.booking.movieBooking.repository.MovieRepository;
import com.movie.booking.movieBooking.repository.MovieShowRepository;
import com.movie.booking.movieBooking.repository.ScreenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TheatreShowService {

    private final MovieShowRepository movieShowRepository;
    private final MovieRepository movieRepository;
    private final ScreenRepository screenRepository;

    @Transactional
    public MovieShow createShow(CreateShowRequestDTO request) {

        Movie movie = movieRepository.findById(request.getMovieId())
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        Screen screen = screenRepository.findById(request.getScreenId())
                .orElseThrow(() -> new RuntimeException("Screen not found"));

        MovieShow show = new MovieShow();
        show.setMovie(movie);
        show.setScreen(screen);
        show.setShowDate(request.getShowDate());
        show.setStartTime(request.getStartTime());
        show.setEndTime(request.getEndTime());
        show.setBasePrice(request.getBasePrice());

        return movieShowRepository.save(show);
    }

    @Transactional
    public MovieShow updateShow(Long showId, UpdateShowRequestDTO request) {

        MovieShow show = movieShowRepository.findById(showId)
                .orElseThrow(() -> new RuntimeException("Show not found"));

        show.setStartTime(request.getStartTime());
        show.setEndTime(request.getEndTime());
        show.setBasePrice(request.getBasePrice());

        return movieShowRepository.save(show);
    }

    @Transactional
    public void deleteShow(Long showId) {

        MovieShow show = movieShowRepository.findById(showId)
                .orElseThrow(() -> new RuntimeException("Show not found"));

        movieShowRepository.delete(show);
    }
}
