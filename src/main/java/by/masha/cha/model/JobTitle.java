package by.masha.cha.model;

public class JobTitle {

    public Integer id;

    public java.lang.String jobTitleName;

    public JobTitle() {
    }

    public JobTitle(Integer id, java.lang.String jobTitleName) {
        this.id = id;
        this.jobTitleName = jobTitleName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public java.lang.String getJobTitleName() {
        return jobTitleName;
    }

    public void setJobTitleName(java.lang.String jobTitleName) {
        this.jobTitleName = jobTitleName;
    }
}

