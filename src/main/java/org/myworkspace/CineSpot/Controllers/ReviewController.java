package org.myworkspace.CineSpot.Controllers;

import org.myworkspace.CineSpot.DTOs.Requests.ReviewRequest;
import org.myworkspace.CineSpot.DTOs.Responses.ReviewResponse;
import org.myworkspace.CineSpot.Services.ReviewService;
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
