package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//JPAのエンティティクラスであることを示す。
@Entity

//テーブルの指定
@Table(name = "customers")
@Data

//JPAの仕様上デフォルトコンストラクタを作成する必要がある。
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String first_name;

    @Column(nullable = false)
    private String last_name;
}

