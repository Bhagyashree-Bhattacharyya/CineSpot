package org.myworkspace.MovieReview.Repositories;

import org.myworkspace.MovieReview.Entities.Genre;
import org.myworkspace.MovieReview.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, String> {

    public Movie findByTitle(String title);
    public List<Movie> findByGenre(Genre genre);
}
