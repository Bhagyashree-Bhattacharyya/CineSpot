package org.myworkspace.MovieReview.Services;

import org.myworkspace.MovieReview.DTOs.Requests.MovieRequest;
import org.myworkspace.MovieReview.DTOs.Responses.MovieResponse;
import org.myworkspace.MovieReview.Repositories.MovieRepository;
import org.myworkspace.MovieReview.Entities.Movie;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private MovieRepository movieRepository;

    public AdminService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(MovieRequest movieRequest){
        return movieRepository.save(movieRequest.toMovie());
    }
}
