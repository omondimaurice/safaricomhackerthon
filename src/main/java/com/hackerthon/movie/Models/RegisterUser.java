package com.hackerthon.movie.Models;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class RegisterUser {


    @Size(min = 3,message = "{username.length}")
    @NotBlank(message = "{username.notempty}")
    public String username;

    @Size(min = 8,message = "{password.length}")
    @NotBlank(message = "{* password.should not be left blnk}")
    public String password;

    @NotBlank(message = "{email.should not be balnk}")
    @Email(message = "{email.not_valid}")
    public String email;
}

