package com.example.etudientapp.security.service;

import com.example.etudientapp.security.entities.AppRole;
import com.example.etudientapp.security.entities.AppUser;


public interface SecurityService {
AppUser saveNewUser(String userName, String password, String rePssword);
AppRole saveNewRole(String roleName, String description);
void addRoleToUser(String userName,String roleName);
void removeRoleFromUser(String userName,String roleName);
AppUser loadUserByUserName(String userName);


}
