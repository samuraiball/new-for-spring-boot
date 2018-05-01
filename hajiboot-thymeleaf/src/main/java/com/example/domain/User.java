package com.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
//customersの循環参照を防ぐため
@ToString(exclude = "customers")
public class User {

    @Id
    private String username;

    //Jsonで出力をする場合、パスワードなどをフィールドから除外するためにつける。
    @JsonIgnore
    private String encodedPassword;


    @JsonIgnore
    //「cascade= CascadeType.ALL」Userのデータに対する操作をCustomerの方にも伝播させることができる。例えばUserを削除すると関連するCustomerも削除される。
    //「fetch = FetchType.LAZY」を有効にすることで関連するエンティティを「遅延ロード」させることができる。
    //本当に必要になったときにCustomerがロードされる。
    @OneToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private List<Customer> customers;
}
