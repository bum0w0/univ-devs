package com.hallym.redisprac.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor //기본 생성자
@AllArgsConstructor // 모든 필드를 받는 생성자
public class User implements Serializable {
//객체를 redis에 저장하려면 직렬화를 해야 한다.
    private String id;
    private String name;
    private int age;

}
