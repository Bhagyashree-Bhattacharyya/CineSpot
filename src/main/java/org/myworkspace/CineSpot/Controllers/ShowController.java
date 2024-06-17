package org.myworkspace.CineSpot.Controllers;

import org.myworkspace.CineSpot.DTOs.Responses.ShowResponse;
import org.myworkspace.CineSpot.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ShowController {
    @Autowired
    private ShowService showService;

    @GetMapping("/searchShows")
    public ResponseEntity<List<ShowResponse>> searchShows(
                         @RequestParam(name="city") String cityName,
                         @RequestParam(name="movieName", required = false) String movieName){
        return ResponseEntity.ok(showService.searchShows(cityName, movieName));
    }
}
