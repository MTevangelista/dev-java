/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.ExemploFeign;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ericson
 */
@RestController
public class PostController {
    private final PostService ps;

    public PostController(PostService ps) {
        this.ps = ps;
    }
    
    //@RequestMapping(method = {RequestMethod.GET}, value = "posts") 
    @GetMapping("posts")
    public ArrayList<Post> buscaPosts(){
        return ps.buscaPosts();
    } 
    
    @GetMapping("posts/{id}")
    public Post buscaPostPor(@PathVariable int id){
        return ps.buscaPostPor(id);
    }
    
    @PostMapping("posts")
    public Post salvarPost(@RequestBody Post p){
       
       /* 
        Post p = new Post();
        p.setUserId(userId);
        p.setId(id);
        p.setTitle(title);
        p.setBody(body);*/
        System.out.println(p);
        return ps.salvarPost(p);
    }
}
