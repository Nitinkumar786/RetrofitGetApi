package com.example.getcomment;

import com.google.gson.annotations.SerializedName;

public class Comment {
    private String postId;
    private String id;
    private String name;
    private String email;
    @SerializedName("body")
    private String text;

    public String getPostId() {
        return postId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getText() {
        return text;
    }
}
