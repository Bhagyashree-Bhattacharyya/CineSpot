package org.myworkspace.MovieReview;

import javax.annotation.PostConstruct;
import org.myworkspace.MovieReview.Services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class InitializationUtil {

    @Autowired
    private ReviewService reviewService;

    @PostConstruct
    @Transactional
    public void initializeReviewsWithUuids() {
        reviewService.addUuidsToExistingReviews();
    }
}

