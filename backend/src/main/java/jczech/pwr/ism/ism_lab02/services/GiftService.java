package jczech.pwr.ism.ism_lab02.services;

import jczech.pwr.ism.model.CreateGiftDTO;
import jczech.pwr.ism.model.GetGiftDTO;
import jczech.pwr.ism.model.UpdateGiftDTO;

import java.util.List;


public interface GiftService {
    GetGiftDTO getGiftById(Long giftId);
    List<GetGiftDTO> getGiftsByTags(List<String> tags, double minRange, double maxRange, int page, int pageSize);
    void CreateNewGift(CreateGiftDTO createGiftDTO);
    void UpdateGift(Long giftId, UpdateGiftDTO updateGiftDTO);
}
