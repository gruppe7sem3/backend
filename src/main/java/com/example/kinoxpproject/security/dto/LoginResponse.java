package com.example.kinoxpproject.security.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginResponse {
    private Integer custId;
    private int isAdmin;

    public LoginResponse(Integer custId, int isAdmin) {
        this.custId = custId;
        this.isAdmin = isAdmin;
    }

}
