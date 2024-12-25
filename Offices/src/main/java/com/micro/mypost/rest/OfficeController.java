package com.micro.mypost.rest;

import com.micro.mypost.office.Office;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

@RestController
class OfficeController {
    @GetMapping("/api/offices")
    public List<OfficeDTO> getAllOffice() {
        return Stream.of(
                        new Office("1", "ул.Пушкина д.Колотушкина", "10-20, Перерыв с 12-13"),
                        new Office("2", "ул.Луганка д.2", "10-20, Перерыв с 12-13"),
                        new Office("3", "ул.Красная Площадь д.1", "10-20, Перерыв с 12-13"))
                .map(office -> new OfficeDTO()
                        .setNumber(office.number()).setAddress(office.address()).setWorkTime(office.workTime()))
                .toList();
    }
}
