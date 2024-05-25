package com.example.study.model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddAuctionInput {

    @NotBlank(message = "상품 이름은 비어있을 수 없습니다.")
    private String name;
    @NotBlank(message = "상품 설명은 비어있을 수 없습니다.")
    private String description;
    @Min(value = 100, message = "시작 가격은 최소 100이어야 합니다.")
    @Max(value = 10000000, message = "시작 가격은 10000000을 초과할 수 없습니다.")
    private int startingPrice;
}
