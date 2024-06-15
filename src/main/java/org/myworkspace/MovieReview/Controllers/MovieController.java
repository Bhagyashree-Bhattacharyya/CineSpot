package org.myworkspace.MovieReview.Controllers;

import org.myworkspace.MovieReview.DTOs.Responses.MovieResponse;
import org.myworkspace.MovieReview.Entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/searchbytitle")
    public MovieResponse findMovie(String title){
        return movieService.findMovie(title);
    }

    @GetMapping("/filterbygenre")
    public List<MovieResponse> findMovieByGenre(@RequestParam String genre){
        return movieService.findMoviesByGenre(genre);
    }
}
