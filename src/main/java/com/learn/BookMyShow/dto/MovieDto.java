package com.learn.BookMyShow.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude
public class MovieDto {

    @NotEmpty(message =  "chal chutiye")
    private String movieCode;
    @NotNull
    private String movieTitle;
    @NotNull
    private String releaseDate;
    @NotNull
    private String language;
}
