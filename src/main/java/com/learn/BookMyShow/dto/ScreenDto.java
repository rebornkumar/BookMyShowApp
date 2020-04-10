package com.learn.BookMyShow.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@NotNull
public class ScreenDto {

    private Integer theatreId;
    @NotEmpty
    private List<ShowDto> showDtoList = new ArrayList<ShowDto>();
}
