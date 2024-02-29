package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Donation;
import com.example.demo.repository.DonationRepository;

@Service
public class DonationService {
    @Autowired
    private DonationRepository donationRepository;
    @SuppressWarnings("null")
    public Donation createdonation(Donation donation){
            return donationRepository.save(donation);
    }
    public List<Donation> getAllStudents(){
        return donationRepository.findAll();
    }
    public Donation getDonationid(int donation_id){
    return donationRepository.findById(donation_id).orElse(null);
    }
    public Page<Donation> paginationdonation(int offset,int pagesize)
    {
        return donationRepository.findAll(PageRequest.of(offset,pagesize));
    }
    public Page<Donation> pageSortDonation(int offset,int pagesize,String field)
    {
        PageRequest pageRequest=PageRequest.of(offset, pagesize , Sort.by(field));
        return donationRepository.findAll(pageRequest);
    }

}