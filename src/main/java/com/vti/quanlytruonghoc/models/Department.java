package com.vti.quanlytruonghoc.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "department") // Bat buoc phai co
@Entity // Bat buoc phai co
public class Department {
    // @Id hieu day la khoa chinh cua Table
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    private String name;
    private String desc;

    public Department(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
}
