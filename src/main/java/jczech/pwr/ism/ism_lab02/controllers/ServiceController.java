package jczech.pwr.ism.ism_lab02.controllers;

import jczech.pwr.ism.api.ServiceApi;
import jczech.pwr.ism.model.UpdateServiceDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;


@RestController
public class ServiceController implements ServiceApi {

    @Override
    public ResponseEntity<Void> updateServiceById(Long businessId, Long serviceId, UpdateServiceDTO updateServiceDTO) {
        return ServiceApi.super.updateServiceById(businessId, serviceId, updateServiceDTO);
    }
}
