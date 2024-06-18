package org.myworkspace.CineSpot.Controllers;

import org.myworkspace.CineSpot.DTOs.Responses.TheaterResponse;
import org.myworkspace.CineSpot.DTOs.Requests.TheaterRequest;
import org.myworkspace.CineSpot.Services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @PostMapping("/add")
    public ResponseEntity<TheaterResponse> addTheater(@RequestBody TheaterRequest theaterInfo) {
        return ResponseEntity.ok(theaterService.addTheater(theaterInfo));
    }

    @GetMapping("/{name}")
    public ResponseEntity<TheaterResponse> getTheater(@PathVariable(name = "name") String name,
                                                   @RequestParam(name="city") String cityName) {
        return ResponseEntity.ok(theaterService.getTheater(name, cityName));
    }

    @GetMapping("/findByCity")
    public ResponseEntity<TheaterResponse> findTheater(@RequestParam(name="city") String cityName) {
        return ResponseEntity.ok(theaterService.findTheater(cityName));
    }
}
