package org.myworkspace.CineSpot.Services;

import org.myworkspace.CineSpot.DTOs.Responses.MovieResponse;
import org.myworkspace.CineSpot.Entities.enums.Genre;
import org.myworkspace.CineSpot.Entities.Movie;
import org.myworkspace.CineSpot.Repositories.MovieRepository;
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
