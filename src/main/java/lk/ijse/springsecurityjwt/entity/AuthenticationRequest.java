package lk.ijse.springsecurityjwt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Nipun Chathuranga <nipunc1999@gmail.com>
 * @since : 5/22/2021
 **/

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthenticationRequest {
    private String userName;
    private String password;

}
