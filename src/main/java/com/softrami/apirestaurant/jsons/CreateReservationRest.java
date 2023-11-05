package com.softrami.apirestaurant.jsons;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateReservationRest {

    @JsonProperty("date")
    private Date date;
    @JsonProperty("person")
    private Long person;
    @JsonProperty("turnId")
    private Long turnId;
    @JsonProperty("restaurantId")
    private Long restaurantId;
}
