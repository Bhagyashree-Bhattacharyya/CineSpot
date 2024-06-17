package org.myworkspace.CineSpot.Controllers;

import org.myworkspace.CineSpot.DTOs.Responses.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.myworkspace.CineSpot.Services.MovieService;

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
