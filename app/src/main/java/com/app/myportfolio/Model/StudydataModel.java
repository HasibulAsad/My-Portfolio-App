package com.app.myportfolio.Model;

public class StudydataModel {
    String jobtime;
    String jobtitle;
    String jobcompany;
    String jobdescription;

    public StudydataModel(String jobtime, String jobtitle, String jobcompany, String jobdescription) {
        this.jobtime = jobtime;
        this.jobtitle = jobtitle;
        this.jobcompany = jobcompany;
        this.jobdescription = jobdescription;
    }

    public String getJobtime() {
        return jobtime;
    }

    public void setJobtime(String jobtime) {
        this.jobtime = jobtime;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getJobcompany() {
        return jobcompany;
    }

    public void setJobcompany(String jobcompany) {
        this.jobcompany = jobcompany;
    }

    public String getJobdescription() {
        return jobdescription;
    }

    public void setJobdescription(String jobdescription) {
        this.jobdescription = jobdescription;
    }
}
