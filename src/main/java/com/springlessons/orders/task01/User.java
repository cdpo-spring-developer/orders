package com.springlessons.orders.task01;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import reactor.core.publisher.Mono;

@Data
public class User {
    @JsonProperty("f_name")
    private String firstName;
    @JsonProperty("l_name")
    private String lastName;
    private String email;

}
