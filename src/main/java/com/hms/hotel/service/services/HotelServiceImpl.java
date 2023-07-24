package com.hms.hotel.service.services;

import com.hms.hotel.service.dto.HotelRequestDto;
import com.hms.hotel.service.dto.HotelResponseDto;
import com.hms.hotel.service.entities.Hotel;
import com.hms.hotel.service.exception.ResourceNotFoundException;
import com.hms.hotel.service.repositories.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService{

    private final HotelRepository hotelRepository;
    private static UUID uid;

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public HotelResponseDto saveHotelDetails(HotelRequestDto request) {
        Hotel hotel= Hotel.builder()
                .hotelUid(uid.randomUUID().toString())
                .name(request.getName())
                .about(request.getAbout())
                .location(request.getLocation())
                .build();
        Hotel save = hotelRepository.save(hotel);

        HotelResponseDto response= HotelResponseDto.builder()
                .hotelId(save.getId())
                .hotelUid(save.getHotelUid())
                .about(save.getAbout())
                .location(save.getLocation())
                .name(save.getName())
                .build();

        return response;
    }

    @Override
    public List<HotelResponseDto> findAllHotels() {
        List<Hotel> hotelList = hotelRepository.findAll();
        List<HotelResponseDto> hotelResponseDtoList=new ArrayList<>();
        if(!hotelList.isEmpty()){
           hotelList.forEach(save->{
               HotelResponseDto response= HotelResponseDto.builder()
                       .hotelId(save.getId())
                       .hotelUid(save.getHotelUid())
                       .about(save.getAbout())
                       .location(save.getLocation())
                       .name(save.getName())
                       .build();
               hotelResponseDtoList.add(response);
           });
        }
        return hotelResponseDtoList;
    }

    @Override
    public HotelResponseDto findByHotelId(Integer id) {

        Optional<Hotel> hotelOptional = hotelRepository.findById(id);
        if(!hotelOptional.isPresent()){
            throw  new ResourceNotFoundException("hotel details not present with the given id");
        }
        Hotel save = hotelOptional.get();
        HotelResponseDto response= HotelResponseDto.builder()
                .hotelId(save.getId())
                .hotelUid(save.getHotelUid())
                .about(save.getAbout())
                .location(save.getLocation())
                .name(save.getName())
                .build();

        return response;
    }

    @Override
    public HotelResponseDto fetchHotelDetails(String hotelUid) {
        Optional<Hotel> hotelOptional = hotelRepository.findByHotelUid(hotelUid);
        if(!hotelOptional.isPresent()){
            throw  new ResourceNotFoundException("hotel details not present with the given id");
        }
        Hotel save = hotelOptional.get();
        HotelResponseDto response= HotelResponseDto.builder()
                .hotelUid(save.getHotelUid())
                .about(save.getAbout())
                .location(save.getLocation())
                .name(save.getName())
                .build();

        return response;
    }
}
