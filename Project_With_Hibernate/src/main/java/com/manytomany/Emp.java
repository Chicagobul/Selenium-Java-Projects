package com.manytomany;

import javax.persistence.*;
import java.util.List;

@Entity
public class Emp
{
    @Id
    private int e_id;
    private String name;
    @ManyToMany
    @JoinTable
            (       name = "emp_learn",
                    joinColumns = {@JoinColumn(name = "eid")},
                    inverseJoinColumns = {@JoinColumn(name = "pid")}
            )
    // InverseJoinColumn is used to customize the column name in the table of the associated class reference
    // variable name. that column act as a foreign key.
    private List<Project> projects;

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Emp(int e_id, String name, List<Project> projects) {
        this.e_id = e_id;
        this.name = name;
        this.projects = projects;
    }

    public Emp()
    {
        super();
    }
}
