package com.vti.quanlytruonghoc.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentInfo {

    private int id;
    private String name;
    private String desc;

    public DepartmentInfo(Department department){
        this.setId(department.getId());
        this.setName(department.getName());
        this.setDesc(department.getDesc());

    }
}
