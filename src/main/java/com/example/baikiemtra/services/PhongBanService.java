package com.example.baikiemtra.services;

import com.example.baikiemtra.entity.PHONGBAN;
import com.example.baikiemtra.repository.IPhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongBanService {
    @Autowired
    private IPhongBanRepository phongBanRepository;

    public List<PHONGBAN> getAllPhongBan(){
        return phongBanRepository.findAll();
    }
    public PHONGBAN getPhongBanById(String id){
        return phongBanRepository.findById(id).orElse(null);
    }
    public PHONGBAN savePhongBan(PHONGBAN phongban){
        return phongBanRepository.save(phongban);
    }

    public void deletePhongBan(String id){
        phongBanRepository.deleteById(id);
    }
}
