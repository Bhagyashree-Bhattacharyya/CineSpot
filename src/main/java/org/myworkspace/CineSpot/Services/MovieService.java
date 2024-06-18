package org.myworkspace.CineSpot.Services;

import jakarta.persistence.EntityNotFoundException;
import org.myworkspace.CineSpot.DTOs.Requests.MovieRequest;
import org.myworkspace.CineSpot.DTOs.Responses.MovieResponse;
import org.myworkspace.CineSpot.Entities.enums.Genre;
import org.myworkspace.CineSpot.Entities.Movie;
import org.myworkspace.CineSpot.Repositories.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class MovieService {

    private static final Logger log = LoggerFactory.getLogger(MovieService.class);

    @Autowired
    private MovieRepository movieRepository;
    
    public MovieResponse findMovie(String movieName) {
        Movie movie = movieRepository.findByTitle(movieName);
        return movie.toMovieResponse();
    }

    public List<MovieResponse> findMoviesByGenre(String genre) {
        if(Arrays.stream(Genre.values()).noneMatch(g -> g.toString().equals(genre))){
            return new ArrayList<>();
        }
        List<Movie> movieList = movieRepository.findByGenre(Genre.valueOf(genre));
        if(!CollectionUtils.isEmpty(movieList)) {
            List<MovieResponse> movieResponseList = movieList.stream()
                    .sorted(Comparator.comparing(Movie::getRating, Comparator.reverseOrder()))
                    .map(Movie::toMovieResponse).toList();
            if (movieList.size() > 5) {
                return movieResponseList.subList(0, 4);
            }
            return movieResponseList;
        }
        return new ArrayList<>();
    }

    public MovieResponse addMovie(MovieRequest movieRequest) {
//            return movieRepository.save(movieRequest.toMovie()).toMovieResponse();
        Movie movie = movieRequest.toMovie();
        if (movieRepository.existsByTitle(movieRequest.getTitle())) {
            return movie.toMovieResponse(); // need to refactor -- return HttpStatus.CONFLICT
        }
        movie = movieRepository.save(movie);
        log.info("Added New Movie{}", movie);
        return movie.toMovieResponse();
    }

    public MovieResponse getMovie(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isEmpty()) {
            throw new EntityNotFoundException("Movie not found:" + id);
        }
        return movie.get().toMovieResponse();
    }

}
