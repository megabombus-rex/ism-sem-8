package jczech.pwr.ism.ism_lab02.controllers;

import jczech.pwr.ism.api.ReviewApi;
import jczech.pwr.ism.model.CreateReviewDTO;
import jczech.pwr.ism.model.GetGiftReviews201ResponseInner;
import jczech.pwr.ism.model.GetReviewDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;


@RestController
public class ReviewController implements ReviewApi {
    @Override
    public Optional<NativeWebRequest> getRequest() {
        return ReviewApi.super.getRequest();
    }

    @Override
    public ResponseEntity<List<GetGiftReviews201ResponseInner>> getGiftReviews(Long giftId, Integer count, Integer page) {
        return ReviewApi.super.getGiftReviews(giftId, count, page);
    }

    @Override
    public ResponseEntity<GetReviewDTO> getReviewById(Long reviewId) {
        return ReviewApi.super.getReviewById(reviewId);
    }

    @Override
    public ResponseEntity<Void> leaveGiftReviewById(Long giftId, CreateReviewDTO createReviewDTO) {
        return ReviewApi.super.leaveGiftReviewById(giftId, createReviewDTO);
    }
}
