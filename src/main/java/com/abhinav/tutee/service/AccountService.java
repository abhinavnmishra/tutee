package com.abhinav.tutee.service;

import com.abhinav.tutee.model.Account;
import com.abhinav.tutee.model.Admin;
import com.abhinav.tutee.model.consts.AccountRole;
import com.abhinav.tutee.repository.AccountRepository;
import com.abhinav.tutee.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    public Account createAccount(String username, String password, AccountRole role){
        Account account = new Account();
        account.setUsername(username);
        account.setRoles(Arrays.asList(role));
        account.setPassword(passwordEncoder.encode(password));
        account = accountRepository.save(account);
        return account;
    }

    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public Admin createAdmin(Admin adminDto){
        Account account = createAccount(adminDto.getAccount().getUsername(), adminDto.getAccount().getPassword(), AccountRole.ROLE_ADMIN);
        Admin admin = new Admin();
        admin.setAccount(account);
        admin.setFirstName(adminDto.getFirstName());
        admin.setLastName(adminDto.getLastName());
        admin.setEmail(adminDto.getEmail());

        return adminRepository.save(admin);
    }

}
