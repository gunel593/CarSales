package com.example.CarSales.service;

import com.example.CarSales.Util.JwtProvider;
import com.example.CarSales.mapper.UserMapper;
import com.example.CarSales.model.dto.Request.LoginRequest;
import com.example.CarSales.model.dto.Request.RegistrRequest;
import com.example.CarSales.model.dto.Responce.LoginResponce;
import com.example.CarSales.model.dto.Responce.UserResponce;
import com.example.CarSales.model.entity.User;
import com.example.CarSales.repository.UserMybatisRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpli implements UserService {
    private final UserMybatisRepo usermybatis;
    private final UserMapper userMapper;
   // private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginResponce login(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword());
     //authenticationManager.authenticate(authenticationToken);
     Optional<User> userOptional=getByUsername(loginRequest.getUsername());

     if(userOptional.isEmpty()){
     return LoginResponce.withResponce("user is not exists");
     }
        String token= jwtProvider.generatedToken(userOptional.get());
     return LoginResponce.withToken(token);
    }
    @Override
    public UserResponce registr(RegistrRequest registrRequest) {
        if (!Objects.equals(registrRequest.getPassword(), registrRequest.getConfirmPassword())) {
            return new UserResponce("Password is not true");
        }
        Optional<User> byUserName = usermybatis.findByUsername(registrRequest.getUsername());
        if (byUserName.isPresent()) {
            return new UserResponce(("Dublicate username"));
        }

        User user = userMapper.toUser(registrRequest);
        user.setPassword(passwordEncoder.encode(registrRequest.getPassword()));
        usermybatis.insert(user);
        return new UserResponce("success");
       // String token =jwtProvider.generatedToken(user);
    }


    @Override
    public Optional<User> getByUsername(String username) {
        return usermybatis.findByUsername(username);
    }

}
