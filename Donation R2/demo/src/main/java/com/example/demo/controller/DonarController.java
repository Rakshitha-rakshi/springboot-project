package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Donar;
import com.example.demo.service.DonarService;

@RestController
public class DonarController {

    @Autowired
    private DonarService donarService;

    @PostMapping("/postbydonar")
    public ResponseEntity<Donar> post(@RequestBody Donar donar) {

        try {
            return new ResponseEntity<>(donarService.create(donar), HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/get/bydonarId/{id}")
    public ResponseEntity<Donar> getById(@PathVariable int id) {
        Donar s = donarService. getDonarid(id);
        if (s != null) {
            return new ResponseEntity<>(s, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/api/updateage/{id}")
    public ResponseEntity<Void> put(@PathVariable int id, @RequestParam int age) {
        donarService.putDonar(id, age);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/donar/{offset}/{pagesize}")
    public ResponseEntity<Page<Donar>> getPaginationDonar(@PathVariable("offset") int offset,@PathVariable("pagesize") int pagesize) 
    {
        Page<Donar> b=donarService.paginationdonar(offset,pagesize);
        if(b!=null)
        {
            return new ResponseEntity<>(b,HttpStatus.OK);
        }
        return new ResponseEntity<>(b,HttpStatus.NOT_FOUND);
    }
    @GetMapping("/api/donar/sortBy/{field}")
    public ResponseEntity<List<Donar>> sortpro(@PathVariable ("field") String field)
    {
        List<Donar> b=donarService.pageSortDonarPage(field);
        if(b!=null)
        {
                return new ResponseEntity<>(b,HttpStatus.OK);
        }
        return new ResponseEntity<>(b,HttpStatus.NOT_FOUND);
    }
}