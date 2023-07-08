package com.manytomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Project
{
    @Id
    private int p_id;
    @Column(name = "project_name")
    private String projectName;
    @ManyToMany(mappedBy = "projects")
    private List<Emp> emps;

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    public Project(int p_id, String projectName, List<Emp> emps) {
        this.p_id = p_id;
        this.projectName = projectName;
        this.emps = emps;
    }

    public Project()
    {
        super();
    }
}
