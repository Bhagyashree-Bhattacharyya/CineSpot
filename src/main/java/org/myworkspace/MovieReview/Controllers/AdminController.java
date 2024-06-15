package org.myworkspace.MovieReview.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.myworkspace.MovieReview.Services.AdminService;
import org.myworkspace.MovieReview.DTOs.Responses.MovieResponse;
import org.myworkspace.MovieReview.DTOs.Requests.MovieRequest;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("addMovie")
    public ResponseEntity<MovieResponse> addMovie(@RequestBody MovieRequest movieRequest){
        return new ResponseEntity<>(adminService.addMovie(movieRequest.toMovie())
                .toMovieResponse(), HttpStatus.CREATED);
    }
}
