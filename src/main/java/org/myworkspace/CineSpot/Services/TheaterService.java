package org.myworkspace.CineSpot.Services;

import org.myworkspace.CineSpot.DTOs.Requests.TheaterRequest;
import org.myworkspace.CineSpot.DTOs.Responses.TheaterResponse;
import org.myworkspace.CineSpot.Entities.Theater;
import org.myworkspace.CineSpot.Repositories.TheaterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class TheaterService {

    private static final Logger log = LoggerFactory.getLogger(TheaterService.class);

    @Autowired
    private TheaterRepository theaterRepository;

    public TheaterResponse addTheater(TheaterRequest theaterInfo) {
        Theater theater = theaterRepository.save(theaterInfo.toTheater());
        log.info("Added New User [id: {}, Name: {}]", theater.getId(), theater.getName());
        return theater.toTheaterResponse();
    }

    public TheaterResponse getTheater(String name, String cityName) {
        log.info("Searching Theater of name: {} at city: {}", name, cityName);
        Optional<Theater> theaterEntity = theaterRepository.findByNameAndCity(name, cityName);
        if (theaterEntity.isEmpty()) {
            log.error("Theater not found");
            throw new EntityNotFoundException();
        }
        return theaterEntity.get().toTheaterResponse();
    }

    public TheaterResponse findTheater(String cityName) {
        Optional<Theater> theaterEntity = theaterRepository.findByCity(cityName);
        return theaterEntity.map(Theater::toTheaterResponse).orElse(null);
    }
}
