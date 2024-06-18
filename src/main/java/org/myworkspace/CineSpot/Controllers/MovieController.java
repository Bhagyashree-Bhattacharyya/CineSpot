package org.myworkspace.CineSpot.Controllers;

import jakarta.validation.Valid;
import org.myworkspace.CineSpot.DTOs.Requests.MovieRequest;
import org.myworkspace.CineSpot.DTOs.Responses.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.myworkspace.CineSpot.Services.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/addMovie")
    public ResponseEntity<MovieResponse> addMovie(@RequestBody @Valid MovieRequest movieRequest,
                                          @RequestHeader("UserRole") String userRole) {
        if (!"ADMIN".equals(userRole)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN); // too naive --- will refactor
        }
        return new ResponseEntity<>(movieService.addMovie(movieRequest), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> getMovieById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(movieService.getMovie(id));
    }

    @GetMapping("/searchByTitle")
    public MovieResponse findMovie(@RequestParam String movieName){
        return movieService.findMovie(movieName);
    }

    @GetMapping("/searchByGenre")
    public List<MovieResponse> findMovieByGenre(@RequestParam String genre){
        return movieService.findMoviesByGenre(genre);
    }
}
