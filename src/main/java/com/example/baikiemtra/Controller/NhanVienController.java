package com.example.baikiemtra.Controller;

import com.example.baikiemtra.entity.NHANVIEN;
import com.example.baikiemtra.services.NhanVienService;
import com.example.baikiemtra.services.PhongBanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nhanviens")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private PhongBanService phongBanService;

    @GetMapping
    public String showAllNhanVien(Model model){
        List<NHANVIEN> nhanviens = nhanVienService.getAllNV();
        model.addAttribute("nhanviens",nhanviens);
        return "nhanvien/list";
    }

    @GetMapping("/add")
    public String addNhanVienForm(Model model)
    {
        model.addAttribute("nhanvien",new NHANVIEN());
        model.addAttribute("phongbans", phongBanService.getAllPhongBan());
        return "nhanvien/add";
    }
    @PostMapping("/add")
    public String addNhanVien(@Valid @ModelAttribute("nhanvien") NHANVIEN nhanvien, BindingResult result, Model model)
    {
        if(result.hasErrors())
        {
            model.addAttribute("phongbans", phongBanService.getAllPhongBan());
            return "nhanvien/add";
        }
        nhanVienService.addNV(nhanvien);
        return "redirect:/nhanviens";
    }
    @GetMapping("/edit/{id}")
    public String editNhanVienForm(@PathVariable("id") String id, Model model)
    {
        NHANVIEN editNV = nhanVienService.getNVById(id);
        if(editNV != null)
        {
            model.addAttribute("nhanvien",editNV);
            model.addAttribute("phongbans", phongBanService.getAllPhongBan());
            return "nhanvien/edit";
        }else{
            return "not-found";
        }
    }
    @PostMapping("/edit")
    public String editNhanVien(@ModelAttribute("nhanvien") NHANVIEN nhanvien){
        nhanVienService.updateNV(nhanvien);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteNhanVien(@PathVariable("id") String id)
    {
        nhanVienService.deleteNV(id);
        return "redirect:/nhanviens";
    }
}
