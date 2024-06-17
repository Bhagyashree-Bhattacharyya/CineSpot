package org.myworkspace.MovieReview.Repositories;

import org.myworkspace.MovieReview.Entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "select avg(rating) from review where movie_id=?", nativeQuery = true)
    Double getReviewAverage(Long id);

    Optional<Review> findByRefId(String refId);
}
