/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.attributes;

/**
 *
 * @author rital
 */
public class BlogPost {
    
    public String title;
    public String content;
    public String picture;
    public String createdAt;
    public String updatedAt;
    
    public BlogPost(String title, String content, String picture, String createdAt, String updatedAt){
        this.title = title;
        this.content = content;
        this.picture = picture;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
     public BlogPost(){
        this.title = null;
        this.content = null;
        this.picture = null;
        this.createdAt = null;
        this.updatedAt = null;
     }
}
