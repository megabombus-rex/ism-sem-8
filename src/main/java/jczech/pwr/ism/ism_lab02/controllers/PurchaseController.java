package jczech.pwr.ism.ism_lab02.controllers;

import jczech.pwr.ism.api.PurchaseApi;
import jczech.pwr.ism.model.GetGiftDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@RestController
public class PurchaseController implements PurchaseApi {
    @Override
    public Optional<NativeWebRequest> getRequest() {
        return PurchaseApi.super.getRequest();
    }

    @Override
    public ResponseEntity<Void> addItemToClientCart(UUID clientId, UUID body) {
        return PurchaseApi.super.addItemToClientCart(clientId, body);
    }

    @Override
    public ResponseEntity<Void> addItemToClientCartById(UUID clientId, UUID giftId) {
        return PurchaseApi.super.addItemToClientCartById(clientId, giftId);
    }

    @Override
    public ResponseEntity<Void> getClientCart(UUID clientId) {
        return PurchaseApi.super.getClientCart(clientId);
    }

    @Override
    public ResponseEntity<GetGiftDTO> getClientPurchases(UUID clientId, LocalDate dateFrom, LocalDate dateTo, Integer page, Integer count) {
        return PurchaseApi.super.getClientPurchases(clientId, dateFrom, dateTo, page, count);
    }
}
