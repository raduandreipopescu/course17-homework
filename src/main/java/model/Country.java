package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Country {
    private String id;
    private String name;
    private String capital;
    private Long population;
    private Integer area;
    private String continent;
    private List<String> neighbours;
}


