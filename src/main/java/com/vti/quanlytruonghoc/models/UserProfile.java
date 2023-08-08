package com.vti.quanlytruonghoc.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    @JsonIgnore
    @OneToOne(mappedBy = "userProfile")
    // CO nghia la map voi Table User
    // thong qua truong userProfile
    private User user;

    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }

    // getters and setters
}