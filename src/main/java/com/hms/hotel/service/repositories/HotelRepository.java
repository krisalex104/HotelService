package com.hms.hotel.service.repositories;

import com.hms.hotel.service.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Integer> {
    Optional<Hotel> findByHotelUid(String hotelUid);

}
