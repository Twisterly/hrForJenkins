package by.masha.cha.model;

import java.sql.Date;
import java.util.List;

public class Employee {

    public Integer id;

    public java.lang.String firstName;

    public java.lang.String lastName;

    public Date birthDate;

    public java.lang.String cellPhone;

//    public Integer jobId;

    public JobTitle jobTitle;

    public List<java.lang.String> projects;


    public Employee() {
    }



    public Employee(Integer id, java.lang.String firstName,
                    java.lang.String lastName, Date birthDate,
                    java.lang.String cellPhone, JobTitle jobTitle,
                    List<java.lang.String> projects) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.cellPhone = cellPhone;
        this.jobTitle = jobTitle;
        this.projects = projects;
    }

    public Employee(Integer id, java.lang.String firstName,
                    java.lang.String lastName, Date birthDate,
                    java.lang.String cellPhone, JobTitle jobTitle) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.cellPhone = cellPhone;
        this.jobTitle = jobTitle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public java.lang.String getFirstName() {
        return firstName;
    }

    public void setFirstName(java.lang.String firstName) {
        this.firstName = firstName;
    }

    public java.lang.String getLastName() {
        return lastName;
    }

    public void setLastName(java.lang.String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public java.lang.String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(java.lang.String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    public List<java.lang.String> getProjects() {
        return projects;
    }

    public void setProjects(List<java.lang.String> projects) {
        this.projects = projects;
    }
}

