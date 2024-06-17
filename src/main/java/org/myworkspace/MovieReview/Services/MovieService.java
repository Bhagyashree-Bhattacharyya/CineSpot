package org.myworkspace.MovieReview.Services;

import org.myworkspace.MovieReview.DTOs.Responses.MovieResponse;
import org.myworkspace.MovieReview.Entities.Genre;
import org.myworkspace.MovieReview.Entities.Movie;
import org.myworkspace.MovieReview.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class MovieService {

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
}
