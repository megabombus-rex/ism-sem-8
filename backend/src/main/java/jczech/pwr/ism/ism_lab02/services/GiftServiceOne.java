package jczech.pwr.ism.ism_lab02.services;

import jakarta.transaction.Transactional;
import jczech.pwr.ism.ism_lab02.entities.businesses.gifts.Gift;
import jczech.pwr.ism.ism_lab02.entities.businesses.gifts.GiftTag;
import jczech.pwr.ism.ism_lab02.entities.businesses.gifts.Tag;
import jczech.pwr.ism.ism_lab02.repositories.GiftRepository;
import jczech.pwr.ism.ism_lab02.repositories.GiftTagRepository;
import jczech.pwr.ism.ism_lab02.repositories.TagRepository;
import jczech.pwr.ism.model.CreateGiftDTO;
import jczech.pwr.ism.model.GetGiftDTO;
import jczech.pwr.ism.model.UpdateGiftDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;

@Service
@Transactional
public class GiftServiceOne implements GiftService {
    @Autowired
    private GiftRepository giftRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private GiftTagRepository giftTagRepository;

    @Override
    public GetGiftDTO getGiftById(Long giftId) {
        var gift = giftRepository.getById(giftId);

        var giftDto = new GetGiftDTO();
        giftDto.setGiftId(giftId);
        giftDto.setBusinessId(gift.getBusinessId());
        giftDto.setName(gift.getName());
        giftDto.setGiftDescription(gift.getDescription());
        giftDto.setIsService(gift.isService());

        return giftDto;
    }

    @Override
    public List<GetGiftDTO> getGiftsByTags(List<String> tags, double minRange, double maxRange, int page, int pageSize) {
        if (maxRange <= 0)
        {
            maxRange = Double.MAX_VALUE;
        }

        var finalMax = maxRange;

        List<Long> tagIds;

        if (tags.isEmpty()){
            tagIds = tagRepository.findAll().stream().map(x -> x.getId()).collect(Collectors.toList());
        }
        else
        {
            tagIds = tagRepository.getTagIdsByNames(tags);
        }

        var finalTagIds = tagIds;

        var giftIds = giftTagRepository.findAll()
                .stream()
                .filter(x -> finalTagIds.contains(x.tagId))
                .map(x -> x.giftId)
                .collect(Collectors.toSet());
        System.out.println(giftIds);
        var gifts = giftRepository.findAllById(giftIds)
                .stream()
                .filter(g -> g.getPriceInPln() >= minRange && g.getPriceInPln() <= finalMax)
                .collect(Collectors.toList());

        System.out.println(gifts == null ? "null" : gifts.stream().count());

        if (gifts.isEmpty()) {
            return null;
        }



        return gifts.stream().map(x -> {
            var dto = new GetGiftDTO();
            dto.setGiftId(x.getId());
            dto.setName(x.getName());
            dto.setGiftDescription(x.getDescription());
            dto.setIsService(x.isService());
            dto.setCostInPln(x.getPriceInPln());
            dto.setBusinessId(x.getBusinessId());
            dto.setIssuingVendorId(x.getIssuingVendorId());
            dto.setIsArchived(x.isArchived());
            dto.setTags(tagRepository
                    .findAll()
                    .stream()
                    .filter(y ->
                            x
                                    .getGiftTags()
                                    .stream()
                                    .filter(z -> z.getTagId() == y.getId())
                                    .toList().isEmpty())
                    .map(y -> y.getName())
                    .collect(Collectors.toList()
                    )
            );
            return dto;}).toList();
    }

    @Override
    public void CreateNewGift(CreateGiftDTO createGiftDTO) {
        var gift = new Gift(createGiftDTO.getBusinessId(), createGiftDTO.getIssuingVendorId(), createGiftDTO.getName(), createGiftDTO.getGiftDescription(), createGiftDTO.getPriceInPln().floatValue(), createGiftDTO.getIsService(), false);

        var tags = createGiftDTO.getTags();

        var tagsPresent = tagRepository.getTagsByNames(tags);

        var tagsNames = tagsPresent
                .stream()
                .map(x -> x.name)
                .collect(Collectors.toList());

        var tagsToAdd = tags
                .stream()
                .filter(tag -> !tagsNames.contains(tag))
                .collect(Collectors.toList());

        var newTags = new ArrayList<Tag>(tagsToAdd.size() + tagsNames.size());

        for (var tag : tagsToAdd) {
            var newTag = new Tag(tag);
            newTags.add(newTag);
        }

        tagRepository.saveAll(newTags);
        giftRepository.save(gift);
        giftRepository.flush();

        var newGiftTags = new ArrayList<GiftTag>(newTags.size() + tagsPresent.size());

        for (var tag : newTags) {
            var newGT = new GiftTag();
            newGT.setGiftId(gift.id);
            newGT.setTagId(tag.getId());
            newGiftTags.add(newGT);
        }

        for (var tag : tagsPresent) {
            var newGT = new GiftTag();
            newGT.setGiftId(gift.id);
            newGT.setTagId(tag.getId());
            newGiftTags.add(newGT);
        }

        giftTagRepository.saveAll(newGiftTags);
        giftTagRepository.flush();
    }

    @Override
    public void UpdateGift(Long giftId, UpdateGiftDTO updateGiftDTO) {

    }
}
