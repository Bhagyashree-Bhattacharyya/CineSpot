package org.myworkspace.MovieReview.Services;

import org.myworkspace.MovieReview.DTOs.Responses.ReviewResponse;
import org.myworkspace.MovieReview.Entities.Movie;
import org.myworkspace.MovieReview.Repositories.MovieRepository;
import org.myworkspace.MovieReview.Repositories.ReviewRepository;
import org.myworkspace.MovieReview.DTOs.Requests.ReviewRequest;
import org.myworkspace.MovieReview.Entities.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    public void addReview(ReviewRequest reviewRequest){
        reviewRepository.save(reviewRequest.toReview());
        Movie movie = movieRepository.findById(reviewRequest.getMovieId()).orElse(null);
        if (movie != null){
            Double average = reviewRepository.getReviewAverage(movie.getId());
            movie.setRating(average);
            movieRepository.save(movie);
        } // need to refactor to reduce the time complexity, like by scheduling
    }

    public ReviewResponse getReviewById(Long reviewId) {
         Optional<Review> review = reviewRepository.findById(reviewId);
         return review.map(Review::toReviewResponse).orElse(null);
    }
}
