package com.app.myportfolio.Model;

public class SkillRvModel {
    double maxprogress;
    double currentprogress;
    String languageName;


    public SkillRvModel(double maxprogress, double currentprogress, String languageName) {
        this.maxprogress = maxprogress;
        this.currentprogress = currentprogress;
        this.languageName = languageName;
    }

    public double getMaxprogress() {
        return maxprogress;
    }

    public void setMaxprogress(double maxprogress) {
        this.maxprogress = maxprogress;
    }

    public double getCurrentprogress() {
        return currentprogress;
    }

    public void setCurrentprogress(double currentprogress) {
        this.currentprogress = currentprogress;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }
}
