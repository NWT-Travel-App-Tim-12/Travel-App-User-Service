package com.app.travel.service.user.model.dto;

import com.app.travel.service.user.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    public String token;

    public User user;
}
