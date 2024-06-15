package org.myworkspace.MovieReview.Services;

import org.myworkspace.MovieReview.Repositories.MovieRepository;
import org.myworkspace.MovieReview.Entities.Movie;

public class AdminService {

    private MovieRepository movieRepository;

    //constructor injection
    public AdminService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }
}
