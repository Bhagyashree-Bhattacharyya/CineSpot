package org.myworkspace.MovieReview.Services;

import org.springframework.transaction.annotation.Transactional;
import org.myworkspace.MovieReview.DTOs.Responses.ReviewResponse;
import org.myworkspace.MovieReview.Entities.Movie;
import org.myworkspace.MovieReview.Repositories.MovieRepository;
import org.myworkspace.MovieReview.Repositories.ReviewRepository;
import org.myworkspace.MovieReview.DTOs.Requests.ReviewRequest;
import org.myworkspace.MovieReview.Entities.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

//    public void addReview(ReviewRequest reviewRequest){
//        reviewRepository.save(reviewRequest.toReview());
//        Movie movie = movieRepository.findByTitleAndReleaseYear(reviewRequest.getMovieTitle(),
//                                                reviewRequest.getReleaseYear()).orElse(null);
//        if (movie != null){
//            Double average = reviewRepository.getReviewAverage(movie.getId());
//            movie.setRating(average);
//            movieRepository.save(movie);
//        } // need to refactor to reduce the time complexity, like by scheduling
//        else {
//            throw new RuntimeException("Movie not found with title " + reviewRequest.getMovieTitle()
//                                + " and release year " + reviewRequest.getReleaseYear());
//        }
//    }

    @Transactional
    public String addReview(ReviewRequest reviewRequest) {
        Movie movie = movieRepository.findByTitleAndReleaseYear(reviewRequest.getMovieTitle(),
                        reviewRequest.getReleaseYear())
                .orElseGet(() -> createNewMovie(reviewRequest));

        Review review = reviewRequest.toReview();
        review.setMovie(movie);
        review.setRefId(UUID.randomUUID().toString());
        reviewRepository.save(review);

        updateMovieRating(movie);

        return review.getRefId();
    }

    private Movie createNewMovie(ReviewRequest reviewRequest) {
        Movie newMovie = new Movie();
        newMovie.setTitle(reviewRequest.getMovieTitle());
        newMovie.setReleaseYear(reviewRequest.getReleaseYear());
        return movieRepository.save(newMovie);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateMovieRating(Movie movie) {
        Double average = reviewRepository.getReviewAverage(movie.getId());
        movie.setRating(average);
        movieRepository.save(movie);
    }

    public ReviewResponse getReviewById(String refId) {
         Optional<Review> review = reviewRepository.findByRefId(refId);
         return review.map(Review::toReviewResponse).orElse(null);
    }

    @Transactional
    public void addUuidsToExistingReviews() {
        List<Review> reviews = reviewRepository.findAll();
        for (Review review : reviews) {
            if (review.getRefId() == null || review.getRefId().isEmpty()) {
                review.setRefId(UUID.randomUUID().toString());
                reviewRepository.save(review);
            }
        }
    }

}
