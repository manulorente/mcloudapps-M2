package mcloudapps.rest_db_auth.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mcloudapps.rest_db_auth.dto.UserCreateDTO;
import mcloudapps.rest_db_auth.model.Eroles;
import mcloudapps.rest_db_auth.model.Role;
import mcloudapps.rest_db_auth.payload.request.LoginRequest;
import mcloudapps.rest_db_auth.payload.request.SignupRequest;
import mcloudapps.rest_db_auth.payload.response.JwtResponse;
import mcloudapps.rest_db_auth.payload.response.MessageResponse;
import mcloudapps.rest_db_auth.security.jwt.JwtUtils;
import mcloudapps.rest_db_auth.security.services.UserDetailsImplementation;
import mcloudapps.rest_db_auth.service.UserService;
import mcloudapps.rest_db_auth.service.RoleService;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;
  
    @Autowired
    UserService userService;
  
    @Autowired
    RoleService roleService;
  
    @Autowired
    PasswordEncoder encoder;
  
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = this.authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
    
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = this.jwtUtils.generateJwtToken(authentication);
        
        UserDetailsImplementation userDetails = (UserDetailsImplementation) authentication.getPrincipal();    
        List<String> roles = userDetails.getAuthorities().stream()
            .map(item -> item.getAuthority())
            .collect(Collectors.toList());
    
        return ResponseEntity.ok(new JwtResponse(jwt,
                             userDetails.getId(), 
                             userDetails.getUsername(), 
                             userDetails.getEmail(), 
                             roles));
      }
    
        @PostMapping("/signup")
        public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
            if (this.userService.existsByUsername(signUpRequest.getUsername())) {
              return ResponseEntity
                  .badRequest()
                  .body(new MessageResponse("Error: Username is already taken!"));
            }
        
            if (this.userService.existsByEmail(signUpRequest.getEmail())) {
              return ResponseEntity
                  .badRequest()
                  .body(new MessageResponse("Error: Email is already in use!"));
            }
        
            List<String> strRoles = signUpRequest.getRoles();
            List<Role> roles = new ArrayList<>();      

            if (strRoles == null) {
              Role userRole = this.roleService.findByName(Eroles.ROLE_USER);
              roles.add(userRole);
            } else {
              strRoles.forEach(role -> {
                switch (role) {
                case "ROLE_ADMIN":
                  Role adminRole = this.roleService.findByName(Eroles.ROLE_ADMIN);
                  roles.add(adminRole);
                  break;
                default:
                  Role userRole = this.roleService.findByName(Eroles.ROLE_USER);
                  roles.add(userRole);
                }
              });
            }
        
            this.userService.save(new UserCreateDTO(
              signUpRequest.getUsername(),
              signUpRequest.getEmail(),
              this.encoder.encode(signUpRequest.getPassword()),
              roles));
        
            return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
          }
    
    
}
