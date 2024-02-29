package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Donation;
import com.example.demo.service.DonationService;

@RestController
public class DonationController
{
    
     @Autowired
    private DonationService donationService;

    @PostMapping("/postbyDonation")
    public ResponseEntity<Donation> post(@RequestBody Donation donation) {

        try {
            return new ResponseEntity<>(donationService.createdonation(donation), HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/bydonationId/{id}")
    public ResponseEntity<Donation> getById(@PathVariable int id) {
        Donation s = donationService.getDonationid(id);
        if (s != null) {
            return new ResponseEntity<>(s, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/donation/{offset}/{pagesize}")
    public ResponseEntity<Page<Donation>> getPaginationDonation(@PathVariable("offset") int offset,@PathVariable("pagesize") int pagesize) 
    {
        Page<Donation> b=donationService.paginationdonation(offset,pagesize);
        if(b!=null)
        {
            return new ResponseEntity<>(b,HttpStatus.OK);
        }
        return new ResponseEntity<>(b,HttpStatus.NOT_FOUND);
    }
    @GetMapping("/brand/{offset}/{pagesize}/{field}")
    public ResponseEntity<Page<Donation>> getPageSortDonation(@PathVariable("offset") int offset,@PathVariable("pagesize") int pagesize,@PathVariable("field") String field) {
        Page<Donation> sort=donationService.pageSortDonation(offset,pagesize,field);
        if(sort!=null){
            return new ResponseEntity<>(sort,HttpStatus.OK);
        }
        return new ResponseEntity<>(sort,HttpStatus.NOT_FOUND);
    }
}