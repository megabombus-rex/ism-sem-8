package jczech.pwr.ism.ism_lab02.controllers;

import jczech.pwr.ism.api.GiftApi;
import jczech.pwr.ism.model.CreateGiftDTO;
import jczech.pwr.ism.model.GetClientSchedule200ResponseInner;
import jczech.pwr.ism.model.SearchGiftsByTags200ResponseInner;
import jczech.pwr.ism.model.UpdateGiftDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class GiftController implements GiftApi {

    @Override
    public ResponseEntity<List<SearchGiftsByTags200ResponseInner>> searchGiftsByTags(List<String> tags, BigDecimal priceRangeMin, BigDecimal priceRangeMax, Integer page, Integer count){
            var entity = new SearchGiftsByTags200ResponseInner();
            entity.setTags(tags);
            entity.setIsService(true);
            List<SearchGiftsByTags200ResponseInner> list = new ArrayList<SearchGiftsByTags200ResponseInner>();

            list.add(entity);
        return new ResponseEntity<List<SearchGiftsByTags200ResponseInner>>(list, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OffsetDateTime> claimGift(UUID giftId, UUID clientId) {
        return GiftApi.super.claimGift(giftId, clientId);
    }

    @Override
    public ResponseEntity<Void> createGift(UUID businessId, CreateGiftDTO createGiftDTO) {
        return GiftApi.super.createGift(businessId, createGiftDTO);
    }

    @Override
    public ResponseEntity<List<GetClientSchedule200ResponseInner>> getBusinessSchedule(UUID businessId) {
        return GiftApi.super.getBusinessSchedule(businessId);
    }

    @Override
    public ResponseEntity<List<GetClientSchedule200ResponseInner>> _getClientSchedule(UUID clientId) {
        return GiftApi.super._getClientSchedule(clientId);
    }

    @Override
    public ResponseEntity<List<GetClientSchedule200ResponseInner>> getClientSchedule(UUID clientId) {
        return GiftApi.super.getClientSchedule(clientId);
    }

    @Override
    public ResponseEntity<List<SearchGiftsByTags200ResponseInner>> _searchGiftsByTags(List<String> tags, BigDecimal priceRangeMin, BigDecimal priceRangeMax, Integer page, Integer count) {
        return GiftApi.super._searchGiftsByTags(tags, priceRangeMin, priceRangeMax, page, count);
    }

    @Override
    public ResponseEntity<Void> updateGiftById(UUID businessId, UUID giftId, UpdateGiftDTO updateGiftDTO) {
        return GiftApi.super.updateGiftById(businessId, giftId, updateGiftDTO);
    }
}
