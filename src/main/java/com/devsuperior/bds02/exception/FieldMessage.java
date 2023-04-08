package com.devsuperior.bds02.exception;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FieldMessage {
    private String fieldName;
    private String message;
}
