package com.example.learnflatfrombackend.repository;

import com.example.learnflatfrombackend.dto.AdminDTO;
import com.example.learnflatfrombackend.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin,Integer> {

}
