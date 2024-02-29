package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Donar;
import com.example.demo.repository.DonarRepository;

import jakarta.transaction.Transactional;

@Service
public class DonarService {
    @Autowired
    private DonarRepository donarRepository;
    
      @SuppressWarnings("null")
      public Donar create(Donar donar){
            return donarRepository.save(donar);
      }
      public List<Donar> getAllSchools(){
        return donarRepository.findAll();
      }
      public Donar getDonarid(int id){
        return donarRepository.findById(id).orElse(null);
      }
      public Page<Donar> paginationdonar(int offset,int pagesize)
    {
        return donarRepository.findAll(PageRequest.of(offset,pagesize));
    }
    
    public List<Donar>pageSortDonarPage(String field)
    {
        return donarRepository.findAll(Sort.by(Sort.Direction.DESC,field));
    }

    @Transactional
    public void putDonar(int id, int age) {
        donarRepository.updateAge(id, age);
    }
}