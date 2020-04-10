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
public class ShowDto {

    private Integer screenNumber;
    @NotEmpty
    private String movieCode;
    @NotEmpty
    private String movieTitle;
    @NotEmpty
    private String language;
    @NotEmpty
    private String showDate;
    @NotEmpty
    private String showTime;
    private Integer numberOfSeats;
}
