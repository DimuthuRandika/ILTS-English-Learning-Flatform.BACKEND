package com.example.learnflatfrombackend.controller;

import com.example.learnflatfrombackend.dto.AdminDTO;
import com.example.learnflatfrombackend.dto.ResponseDTO;
import com.example.learnflatfrombackend.repository.AdminRepo;
import com.example.learnflatfrombackend.service.AdminService;
import com.example.learnflatfrombackend.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/admin")

public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private ResponseDTO responseDTO;




    @PutMapping(value = "/updateAdmin")
    public ResponseEntity updateAdmin(@RequestBody AdminDTO adminDTO){
        try{
            String res= adminService.updateAdmin(adminDTO);
            if (res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(adminDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }else if(res.equals("01")){
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("Not A Registered Admin");
                responseDTO.setContent(adminDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }else {
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }

        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO,HttpStatus.BAD_REQUEST);

        }

    }
    @GetMapping("/getAllAdmins")
    public ResponseEntity getAllAdmins(){
        try{
            List<AdminDTO> adminDTOList = adminService.getAllAdmin();
            responseDTO.setCode(VarList.RSP_SUCCESS);
            responseDTO.setMessage("Success");
            responseDTO.setContent(adminDTOList);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO,HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("/searchAdmin/{adminID}")
    public ResponseEntity searchAdmin(@PathVariable int adminID){
        try{
            AdminDTO adminDTO= adminService.searchAdmin(adminID);
            if (adminDTO !=null) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(adminDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }else {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No Admin Available for this adminID");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }

        }catch (Exception e){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setContent(e);
            return new ResponseEntity(responseDTO,HttpStatus.BAD_REQUEST);

        }

    }



}
