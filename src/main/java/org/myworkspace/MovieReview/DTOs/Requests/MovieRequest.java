package org.myworkspace.MovieReview.DTOs.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.myworkspace.MovieReview.Entities.Genre;
import org.myworkspace.MovieReview.Entities.Movie;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieRequest {

    private String title;
    private Genre genre;

    public Movie toMovie() {
        return Movie.builder().title(title).genre(genre).rating(0.0).build();
    }
}
