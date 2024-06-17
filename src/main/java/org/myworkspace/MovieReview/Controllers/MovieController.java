package org.myworkspace.MovieReview.Controllers;

import org.myworkspace.MovieReview.DTOs.Responses.MovieResponse;
import org.myworkspace.MovieReview.Entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.myworkspace.MovieReview.Services.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/searchByTitle")
    public MovieResponse findMovie(@RequestParam String movieName){
        return movieService.findMovie(movieName);
    }

    @GetMapping("/searchByGenre")
    public List<MovieResponse> findMovieByGenre(@RequestParam String genre){
        return movieService.findMoviesByGenre(genre);
    }
}
