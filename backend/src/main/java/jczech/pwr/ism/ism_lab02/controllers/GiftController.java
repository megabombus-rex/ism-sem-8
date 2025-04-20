package jczech.pwr.ism.ism_lab02.controllers;

import jczech.pwr.ism.api.GiftApi;
import jczech.pwr.ism.ism_lab02.services.GiftService;
import jczech.pwr.ism.model.CreateGiftDTO;
import jczech.pwr.ism.model.GetClientSchedule200ResponseInner;
import jczech.pwr.ism.model.SearchGiftsByTags200ResponseInner;
import jczech.pwr.ism.model.UpdateGiftDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class GiftController implements GiftApi {

    @Autowired
    GiftService giftService;

    @Override
    public ResponseEntity<List<SearchGiftsByTags200ResponseInner>> searchGiftsByTags(List<String> tags, BigDecimal priceRangeMin, BigDecimal priceRangeMax, Integer page, Integer count){
        if (tags == null){
            tags = new ArrayList<>();
        }
        if(priceRangeMin == null){
            priceRangeMin = BigDecimal.ZERO;
        }
        if(priceRangeMax == null){
            priceRangeMax = BigDecimal.ZERO;
        }

        var list = giftService.getGiftsByTags(tags, priceRangeMin.floatValue(), priceRangeMax.floatValue(), page, count);

        if (list == null || list.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        var translatedList = new ArrayList<SearchGiftsByTags200ResponseInner>();

        for (int i = 0; i < list.size(); i++) {
            var translated = new SearchGiftsByTags200ResponseInner();

            translated.setGiftId(list.get(i).getGiftId());
            translated.setName(list.get(i).getName());
            translated.setGiftDescription(list.get(i).getGiftDescription());
            translated.setBusinessId(list.get(i).getBusinessId());
            translated.setIssuingVendorId(list.get(i).getIssuingVendorId());
            translated.setIsService(list.get(i).getIsService());
            translated.setCostInPln(list.get(i).getCostInPln());
            translated.setIsArchived(list.get(i).getIsArchived());
            translated.setTags(list.get(i).getTags());

            translatedList.add(translated);
        }

        return ResponseEntity.status(HttpStatus.OK).body(translatedList);
    }

    @Override
    public ResponseEntity<OffsetDateTime> claimGift(Long giftId, Long clientId) {
        return GiftApi.super.claimGift(giftId, clientId);
    }

    @Override
    public ResponseEntity<Void> createGift(Long businessId, CreateGiftDTO createGiftDTO) {
        giftService.CreateNewGift(createGiftDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<List<GetClientSchedule200ResponseInner>> getBusinessSchedule(Long businessId) {
        return GiftApi.super.getBusinessSchedule(businessId);
    }

    @Override
    public ResponseEntity<List<GetClientSchedule200ResponseInner>> _getClientSchedule(Long clientId) {
        return GiftApi.super._getClientSchedule(clientId);
    }

    @Override
    public ResponseEntity<List<GetClientSchedule200ResponseInner>> getClientSchedule(Long clientId) {
        return GiftApi.super.getClientSchedule(clientId);
    }

    @Override
    public ResponseEntity<List<SearchGiftsByTags200ResponseInner>> _searchGiftsByTags(List<String> tags, BigDecimal priceRangeMin, BigDecimal priceRangeMax, Integer page, Integer count) {
        return GiftApi.super._searchGiftsByTags(tags, priceRangeMin, priceRangeMax, page, count);
    }

    @Override
    public ResponseEntity<Void> updateGiftById(Long businessId, Long giftId, UpdateGiftDTO updateGiftDTO) {
        return GiftApi.super.updateGiftById(businessId, giftId, updateGiftDTO);
    }
}
