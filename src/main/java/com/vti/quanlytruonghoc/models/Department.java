package com.vti.quanlytruonghoc.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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

    @JsonIgnore
@OneToMany(mappedBy = "department",
        cascade = CascadeType.ALL, fetch = FetchType.EAGER)
private Set<User> users = new HashSet<>();


}
