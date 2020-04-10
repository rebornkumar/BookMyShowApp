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
public class CityDto {
    @NotEmpty
    private String cityCode;
    @NotEmpty
    private String cityName;
    @NotNull
    private Integer pincode;
    private String state;
    private String address;
}
