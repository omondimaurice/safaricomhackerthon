package com.hackerthon.movie.Entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class ApplicationUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(unique = true,nullable = false)
    public String username;

    public String password;

    @Column(unique = true,nullable = false)
    public String email;
    public boolean enabled;
    public boolean accountNonExpired;
    public boolean accountNonLocked;
    public boolean credentialsNonExpired;

    public Date CreatedOn;

}
