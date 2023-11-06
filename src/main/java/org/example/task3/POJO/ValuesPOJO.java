package org.example.task3.POJO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ValuesPOJO {

    @JsonProperty("id")
    private int id;
    @JsonProperty("value")
    private String value;

    @Override
    public String toString() {
        return "{" +
                "id: " + id +
                ", value: " + value +
                "}";
    }
}
