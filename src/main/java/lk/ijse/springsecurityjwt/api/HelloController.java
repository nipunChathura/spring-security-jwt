package lk.ijse.springsecurityjwt.api;

import lk.ijse.springsecurityjwt.entity.AuthenticationRequest;
import lk.ijse.springsecurityjwt.service.MyUserDetailsService;
import lk.ijse.springsecurityjwt.util.AuthenticationResponse;
import lk.ijse.springsecurityjwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Nipun Chathuranga <nipunc1999@gmail.com>
 * @since : 5/22/2021
 **/

@RestController
public class HelloController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello");
        return "Hello World";
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        System.out.println("create authenticate");
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(),
                            authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect userName and password", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
