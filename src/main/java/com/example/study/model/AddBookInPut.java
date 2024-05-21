package com.example.study.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddBookInPut {

    @NotBlank(message = "책 제목은 비어 있을 수 없습니다.")
    @Size(min = 2, max = 20, message = "책 제목은 2자 이상 20자 이하이어야 합니다.")
    private String bookName;

    @Range(min = 100, max = 100000, message = "책 가격은 최소 100원, 최대 100000원이어야 합니다.")
    private long bookPrice;
}

