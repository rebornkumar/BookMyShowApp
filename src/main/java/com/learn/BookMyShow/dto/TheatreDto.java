package com.learn.BookMyShow.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TheatreDto {
    @NotEmpty
    private String theatreName;
    @NotEmpty
    private String description;
    @NotEmpty
    private String cityCode;
    @NotNull
    private Integer ownerId;
}
