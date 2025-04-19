package jczech.pwr.ism.ism_lab02.controllers;

import jczech.pwr.ism.api.AspectApi;
import jczech.pwr.ism.ism_lab02.aspects.StatisticAspect;
import jczech.pwr.ism.model.MethodCountCallsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class AspectController implements AspectApi {

    @Autowired
    private final StatisticAspect statisticAspect;

    @Autowired
    public AspectController(StatisticAspect statisticAspect) {
        this.statisticAspect = statisticAspect;
    }

    @Override
    public ResponseEntity<MethodCountCallsDTO> getCountOfCalls() {
        var dict = statisticAspect.getMethodCallCountDict();
        var keys = dict.keys();
        var list = new ArrayList<String>(dict.size());

        while (keys.hasMoreElements())
        {
            String key = keys.nextElement();
            var count = dict.get(key);
            list.add(key + ": " + count);
        }

        var data = new MethodCountCallsDTO();
        data.setData(list);

        return ResponseEntity.ok(data);
    }
}
