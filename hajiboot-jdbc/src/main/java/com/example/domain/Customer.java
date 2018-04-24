package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Customer implements Serializable{

    private Integer id;
    private String first_name;
    private String last_name;
}
