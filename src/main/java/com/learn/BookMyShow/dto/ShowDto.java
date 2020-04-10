package com.learn.BookMyShow.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShowDto {
    private Integer screenNumber;
    private String movieTitle;
    private String language;
    private String showDate;
    private String showTime;
}
