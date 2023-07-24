package com.hms.hotel.service.controllers;

import com.hms.hotel.service.dto.HotelRequestDto;
import com.hms.hotel.service.dto.HotelResponseDto;
import com.hms.hotel.service.services.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final HotelService hotelService;


    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping
    ResponseEntity<HotelResponseDto> saveHotelDetails(@RequestBody HotelRequestDto requestDto){
        HotelResponseDto hotelResponseDto = hotelService.saveHotelDetails(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelResponseDto);
    }

    @GetMapping
    ResponseEntity<List<HotelResponseDto>> fetchAllHotels(){
        List<HotelResponseDto> allHotels = hotelService.findAllHotels();
        return ResponseEntity.ok(allHotels);
    }

    @GetMapping("/{hotelId}")
    ResponseEntity<HotelResponseDto> fetchHotelById(@PathVariable("hotelId") Integer hotelId){
        HotelResponseDto byHotelId = hotelService.findByHotelId(hotelId);
        return ResponseEntity.ok(byHotelId);
    }

    @GetMapping("/details/{hotelUid}")
    ResponseEntity<HotelResponseDto> fetchHotelByHotelUid(@PathVariable("hotelUid") String hotelUid){
        HotelResponseDto byHotelId = hotelService.fetchHotelDetails(hotelUid);
        return ResponseEntity.ok(byHotelId);
    }
}
