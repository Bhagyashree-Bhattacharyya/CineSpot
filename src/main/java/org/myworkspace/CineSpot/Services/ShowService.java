package org.myworkspace.CineSpot.Services;

import org.myworkspace.CineSpot.DTOs.Responses.ShowResponse;
import org.myworkspace.CineSpot.Entities.Show;
import org.myworkspace.CineSpot.Repositories.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    public List<ShowResponse> searchShows(String cityName, String movieName) {

        if(!StringUtils.hasText(cityName))
            return new ArrayList<>();

        List<Show> shows = new ArrayList<>();
        if(StringUtils.hasText(movieName)){
            shows = showRepository.findByCityNameAndMovieName(cityName, movieName);
        } else {
            showRepository.findByCity(cityName);
        }

        if(CollectionUtils.isEmpty(shows)) return new ArrayList<>();
        else{
            return shows.stream().map(Show::toShowResponse).collect(Collectors.toList());
        }

    }
}
