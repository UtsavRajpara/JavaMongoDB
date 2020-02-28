package com.example.accessingdatamongodb;

import org.springframework.data.annotation.Id;

public class FacebookPost {

    @Id
    public String id;

    public Integer likes;
    public Integer comments;

    public FacebookPost(Integer likes, Integer comments){
        this.likes = likes;
        this.comments = comments;
    }
}
