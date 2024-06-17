package org.myworkspace.CineSpot.Services;

import org.myworkspace.CineSpot.DTOs.Requests.MovieRequest;
import org.myworkspace.CineSpot.Repositories.MovieRepository;
import org.myworkspace.CineSpot.Entities.Movie;
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
