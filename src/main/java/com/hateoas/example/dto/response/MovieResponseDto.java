package com.hateoas.example.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponseDto extends RepresentationModel<MovieResponseDto> {

    private Integer id;
    private String name;
    private Double rating;

}
