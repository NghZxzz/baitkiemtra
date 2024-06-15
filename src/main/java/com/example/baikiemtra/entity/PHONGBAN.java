package com.example.baikiemtra.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Data
@Entity
@Table(name = "PhongBan")
public class PHONGBAN {
    @Id
    @Size(max = 2, min = 1, message = "Mã phòng phải có ít hơn 2 ký tự")
    @Column(name = "Ma_Phong")
    private String Ma_Phong;

    @NotEmpty(message = "Tên phòng không được để trống")
    @Size(max = 30, min = 1, message = "Tên phòng phải có ít hơn 30 ký tự")
    @Column(name = "Ten_Phong")
    private String Ten_Phong;

    @OneToMany(mappedBy = "PhongBan", cascade =  CascadeType.ALL)
    private List<NHANVIEN> nhanviens;
}
