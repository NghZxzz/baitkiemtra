package com.example.baikiemtra.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "NhanVien")
@ToString(exclude = "PhongBan")
public class NHANVIEN {
    @Id
    @Size(max = 3, min = 1, message = "Mã nhân viên phải có ít hơn 3 ký tự")
    @Column(name = "Ma_NV")
    private String Ma_NV;

    @NotNull(message = "Tên nhân viên không được để trống")
    @Size(max = 100, min = 1, message = "Tên phòng phải có ít hơn 100 ký tự")
    @Column(name = "Ten_NV")
    private String Ten_NV;

    @Size(max = 3, min = 1, message = "Phái phải có ít hơn 3 ký tự")
    @Column(name = "Phai")
    private String Phai;

    @Size(max = 100, min = 1, message = "Nơi sinh phải có ít hơn 100 ký tự")
    @Column(name = "Noi_Sinh")
    private String Noi_Sinh;

    @ManyToOne
    @JoinColumn(name = "PhongBan_MaPB", referencedColumnName = "Ma_Phong")
    private PHONGBAN  PhongBan;

    @Column(name = "Luong")
    private int Luong;
}
