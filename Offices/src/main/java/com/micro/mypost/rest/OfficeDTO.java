package com.micro.mypost.rest;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
class OfficeDTO {
    private String number;
    private String address;
    private String workTime;

}
