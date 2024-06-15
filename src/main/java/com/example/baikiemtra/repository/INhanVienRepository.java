package com.example.baikiemtra.repository;


import com.example.baikiemtra.entity.NHANVIEN;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INhanVienRepository extends JpaRepository<NHANVIEN,  String> {
}
