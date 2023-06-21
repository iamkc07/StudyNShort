package com.example.studynshort;

public class QuizModel {

        private String title;
        private String desp;
        private String url;

    public QuizModel() {
        //Firebase
    }

    public QuizModel(String title, String desp, String url) {
        this.title = title;
        this.desp = desp;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesp() {
        return desp;
    }

    public void setDesp(String desp) {
        this.desp = desp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

