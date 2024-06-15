package com.example.baikiemtra.services;

import com.example.baikiemtra.entity.NHANVIEN;
import com.example.baikiemtra.repository.INhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienService {
    @Autowired
    private INhanVienRepository nhanVienRepository;
    public List<NHANVIEN> getAllNV() {
        return nhanVienRepository.findAll();
    }

    public NHANVIEN getNVById(String id) {
        return nhanVienRepository.findById(id).orElse(null);
    }
    public void addNV(NHANVIEN nhanvien) {
        nhanVienRepository.save(nhanvien);
    }
    public void deleteNV (String id) {
        nhanVienRepository.deleteById(id);
    }
    public void updateNV (NHANVIEN nhanvien) {
        nhanVienRepository.save(nhanvien);
    }
}
