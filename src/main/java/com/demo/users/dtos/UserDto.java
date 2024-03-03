package com.demo.users.dtos;

import com.demo.users.models.Role;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private String email;
    private String name;
    @ManyToMany
    private List<Role> roles;
    private boolean isEmailVerified;
}
