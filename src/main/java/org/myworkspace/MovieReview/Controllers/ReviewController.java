package org.myworkspace.MovieReview.Controllers;

import org.myworkspace.MovieReview.DTOs.Requests.ReviewRequest;
import org.myworkspace.MovieReview.DTOs.Responses.ReviewResponse;
import org.myworkspace.MovieReview.Entities.Review;
import org.myworkspace.MovieReview.Services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/addReview")
    public String addReview(@RequestBody ReviewRequest reviewRequest){
        return reviewService.addReview(reviewRequest);
    }

    @GetMapping("/findReview")
    public ReviewResponse getReview(@RequestParam String refId){
        return reviewService.getReviewById(refId);
    }

}
