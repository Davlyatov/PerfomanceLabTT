package org.example.task3.POJO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Arrays;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestsPOJO {

    @JsonProperty("id")
    private int id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("value")
    private String value = "";
    @JsonProperty("values")
    private TestsPOJO[] values;



    @Override
    public String toString() {
        return "{" +
                "id: " + id +
                ", title: " + title +
                ", value: " + value +
                ", values: " + Arrays.toString(values) +
                "}";
    }
}
