package org.myworkspace.MovieReview.Repositories;

import org.myworkspace.MovieReview.Entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "select avg(rating) from review where movie_id=?",nativeQuery = true)
    Double getReviewAverage(String id);
}
