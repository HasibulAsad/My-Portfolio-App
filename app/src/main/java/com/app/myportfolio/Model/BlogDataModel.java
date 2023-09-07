package com.app.myportfolio.Model;

public class BlogDataModel {
    String blogimage;
    String blogtitle;
    String blogdescription;

    public BlogDataModel(String blogimage, String blogtitle, String blogdescription) {
        this.blogimage = blogimage;
        this.blogtitle = blogtitle;
        this.blogdescription = blogdescription;
    }

    public String getBlogimage() {
        return blogimage;
    }

    public void setBlogimage(String blogimage) {
        this.blogimage = blogimage;
    }

    public String getBlogtitle() {
        return blogtitle;
    }

    public void setBlogtitle(String blogtitle) {
        this.blogtitle = blogtitle;
    }

    public String getBlogdescription() {
        return blogdescription;
    }

    public void setBlogdescription(String blogdescription) {
        this.blogdescription = blogdescription;
    }
}
