package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Charity;
import com.example.demo.repository.CharityRepo;
@Service
public class CharityService {
    @Autowired
    private final CharityRepo cr;
    public CharityService(CharityRepo cr) {
        this.cr = cr;
    }
    public Charity create(Charity obj)
    {
        return cr.save(obj);
    }
    public List<Charity> getAll()
    {
        return cr.findAll();
    }
    public Charity getById(int id)
    {
        return cr.findById(id).orElse(null);
    }
    public void delete(int id) {
        cr.deleteById(id);
  }
  public Charity update(Charity obj) {
     return cr.save(obj);
  }
}