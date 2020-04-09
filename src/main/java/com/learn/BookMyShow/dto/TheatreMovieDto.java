package com.learn.BookMyShow.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TheatreMovieDto {
    private String theatreName;
    private String theatreLocation;
    private ShowDto showDetail;
}
