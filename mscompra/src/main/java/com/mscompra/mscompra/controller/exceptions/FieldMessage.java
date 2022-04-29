package com.mscompra.mscompra.controller.exceptions;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FieldMessage implements Serializable {
    private static final long serializableUID = 1;

    private String fieldName;
    private String message;
}
