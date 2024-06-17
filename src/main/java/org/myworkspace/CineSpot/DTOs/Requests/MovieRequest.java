package org.myworkspace.CineSpot.DTOs.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.myworkspace.CineSpot.Entities.Genre;
import org.myworkspace.CineSpot.Entities.Movie;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieRequest {

    private String title;
    private Genre genre;
    private Integer releaseYear;

    public Movie toMovie() {
        return Movie.builder().title(title).releaseYear(releaseYear).genre(genre).rating(0.0).build();
    }
}
