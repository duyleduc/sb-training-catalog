package com.training.sbtrainingcatalog.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;


@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class TestMessage implements Serializable {
    private static final long serialVersionUID = -1138446817700416884L;

    @JsonProperty
    private String itemId;

    @JsonProperty
    private Long quantity;


}
