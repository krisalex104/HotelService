package com.hms.hotel.service.services;


import com.hms.hotel.service.dto.HotelRequestDto;
import com.hms.hotel.service.dto.HotelResponseDto;
import com.hms.hotel.service.repositories.HotelRepository;

import java.util.List;

public interface HotelService {

    HotelResponseDto saveHotelDetails(HotelRequestDto request);

    List<HotelResponseDto> findAllHotels();

    HotelResponseDto findByHotelId(Integer id);

    HotelResponseDto fetchHotelDetails(String hotelUid);

}
