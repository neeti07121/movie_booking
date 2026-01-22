package com.movie.booking.movieBooking.repository;

import com.movie.booking.movieBooking.model.MovieShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieShowRepository extends JpaRepository<MovieShow, Long> {

    @Query("""
        SELECT ms FROM MovieShow ms
        WHERE ms.movie.id = :movieId
          AND ms.screen.theatre.city.id = :cityId
          AND ms.showDate = :showDate
    """)
    List<MovieShow> findShows(
            @Param("movieId") Long movieId,
            @Param("cityId") Long cityId,
            @Param("showDate") LocalDate showDate
    );
}
