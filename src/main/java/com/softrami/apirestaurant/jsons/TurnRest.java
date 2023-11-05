package com.softrami.apirestaurant.jsons;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TurnRest {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
}
