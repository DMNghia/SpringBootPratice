package com.market.phonecardmarket.dto;

import com.market.phonecardmarket.enums.UserStage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String avatar;
    private double balance;
    private String role;
    private UserStage stage;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
