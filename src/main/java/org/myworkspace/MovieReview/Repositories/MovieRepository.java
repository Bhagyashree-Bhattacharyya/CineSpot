package org.myworkspace.MovieReview.Repositories;

import org.myworkspace.MovieReview.Entities.Genre;
import org.myworkspace.MovieReview.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie findByTitle(String title);
    List<Movie> findByGenre(Genre genre);
    Optional<Movie> findByTitleAndReleaseYear(String movieTitle, Integer releaseYear);

}
