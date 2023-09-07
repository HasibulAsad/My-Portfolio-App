package com.app.myportfolio.Model;

public class PortfolioModel {
    String image;
    String projectName;
    String clientName;
    String language;
    String previewString;

    public PortfolioModel(String image, String projectName, String clientName, String language, String previewString) {
        this.image = image;
        this.projectName = projectName;
        this.clientName = clientName;
        this.language = language;
        this.previewString = previewString;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPreviewString() {
        return previewString;
    }

    public void setPreviewString(String previewString) {
        this.previewString = previewString;
    }
}
