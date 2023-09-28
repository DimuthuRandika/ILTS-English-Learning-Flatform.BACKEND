package com.example.learnflatfrombackend.service;

import com.example.learnflatfrombackend.dto.AdminDTO;
import com.example.learnflatfrombackend.entity.Admin;
import com.example.learnflatfrombackend.repository.AdminRepo;
import com.example.learnflatfrombackend.util.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.internal.bytebuddy.description.method.MethodDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional

public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String saveAdmin(AdminDTO adminDTO){
        if(adminRepo.existsById(adminDTO.getAdminID())){
            return VarList.RSP_DUPLICATED;
        }else{
            adminRepo.save(modelMapper.map(adminDTO, Admin.class));
            return VarList.RSP_SUCCESS;
        }
    }
    public String updateAdmin(AdminDTO adminDTO){
        if (adminRepo.existsById(adminDTO.getAdminID())){
            adminRepo.save(modelMapper.map(adminDTO, Admin.class));
            return VarList.RSP_SUCCESS;
        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
    public List<AdminDTO> getAllAdmin(){
        List<Admin> adminList = adminRepo.findAll();
        return modelMapper.map(adminList,new TypeToken<ArrayList<AdminDTO>>(){
        }.getType());
    }


    public AdminDTO searchAdmin(int adminID){
        if (adminRepo.existsById(adminID)){
            Admin admin = adminRepo.findById(adminID).orElse(null);
            return modelMapper.map(admin, AdminDTO.class);
        }else{
            return null;
        }
    }
    public String deleteAdmin(int adminID){
        if(adminRepo.existsById(adminID)){
            adminRepo.deleteById(adminID);
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

}
