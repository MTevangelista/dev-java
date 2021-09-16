/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.ExemploFeign;

import java.util.ArrayList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author ericson
 */
@FeignClient(url="https://jsonplaceholder.typicode.com/posts/", name="PostClient")
public interface PostService {
    
    @GetMapping("{id}")
    Post buscaPostPor(@PathVariable int id);
    
    @GetMapping("")
    ArrayList<Post> buscaPosts();
    
    @PostMapping("")
    Post salvarPost(@RequestBody Post p);
    
    @PutMapping("{id}")
    void atualizarPost(@PathVariable int id, @RequestBody Post p);
    
    @DeleteMapping("{id}")
    Post excluirPost(@PathVariable int id);
}
