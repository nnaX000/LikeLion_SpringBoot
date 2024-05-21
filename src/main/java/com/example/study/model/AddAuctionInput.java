package com.example.study.model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

public class AddAuctionInput {
    @NotBlank(message = "id는 비어있을 수 없습니다.")
    @Size(min = 2, max = 20, message = "책 제목은 2자 이상 20자 이하이어야 합니다.")
    private String name;
    @Size(min = 2, max = 20, message = "설명은 2자 이상 20자 이하이어야 합니다.")
    private String description;
    @Size(min = 2, max = 20, message = "가격은 2자 이상 20자 이하이어야 합니다.")
    private int startingPrice;
}
