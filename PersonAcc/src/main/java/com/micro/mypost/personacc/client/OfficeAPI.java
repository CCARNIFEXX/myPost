package com.micro.mypost.personacc.client;


import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "OfficesClient", url = "${integration.user-gate}", configuration = FeignConfig.class)
public interface OfficeAPI {

    @RequestMapping(method = RequestMethod.GET, value = "/api/offices")
    List<OfficeDTO> getAllOffices();


    @Accessors(chain = true)
    @Data
    class OfficeDTO {
        private String number;
        private String address;
        private String workTime;

    }
}
