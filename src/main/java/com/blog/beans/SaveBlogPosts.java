/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.beans;

import com.blog.db.DbBlogPosts;
import com.blog.db.Singleton;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author drab
 */
public class SaveBlogPosts {
    public Map<String,String> elementBlogPosts = new HashMap();
            
    public SaveBlogPosts(String title, String content, String pictureFile){
        this.elementBlogPosts.put("title", title);
        this.elementBlogPosts.put("content", content);
        this.elementBlogPosts.put("pictureFile", pictureFile);
        System.out.println(this.elementBlogPosts);
    }
    
    public boolean createPost(){
        
        //verification blank input
        for(String value : this.elementBlogPosts.values()){
            if (value.equals("")){
                return false;
            }  
        }
        try {
            DbBlogPosts user = new DbBlogPosts(Singleton.getInstance());
            return user.create(elementBlogPosts);
        } catch (ClassNotFoundException ex) {
            return false;
        }  
    }
    
    
    
}
