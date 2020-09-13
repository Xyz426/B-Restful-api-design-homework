package com.thoughtworks.capability.gtb.restfulapidesign.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    private Integer id;
    private String name;
    private Gender gender;
    private String note;
}
