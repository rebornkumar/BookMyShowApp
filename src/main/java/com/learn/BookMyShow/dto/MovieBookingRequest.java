package com.learn.BookMyShow.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NotNull
public class MovieBookingRequest {
    private Integer endUserId;
    private Integer showId;
    @NotEmpty
    private List<String>seatNumber;
}
