package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

//すべてのフィールドを引数として持つコンストラクタを作成
@AllArgsConstructor
@Data
public class Customer implements Serializable{
    private Integer id;
    private String firstName;
    private String lastName;
}
