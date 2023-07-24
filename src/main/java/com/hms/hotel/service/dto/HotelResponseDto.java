package com.hms.hotel.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelResponseDto {

    @JsonProperty("hotelId")
    private Integer hotelId;

    @JsonProperty("hotelUid")
    private String hotelUid;
    @JsonProperty("name")
    private String name;

    @JsonProperty("location")
    private String location;

    @JsonProperty("about")
    private String about;
}
