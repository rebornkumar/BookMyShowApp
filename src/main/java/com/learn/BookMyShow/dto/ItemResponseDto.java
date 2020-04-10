package com.learn.BookMyShow.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponseDto {

    @NotEmpty
    private String itemType;
    @NotEmpty
    private Integer itemId;
    @NotNull
    private ResponseDto responseDto;
}
