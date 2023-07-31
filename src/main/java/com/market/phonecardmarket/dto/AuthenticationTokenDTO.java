package com.market.phonecardmarket.dto;

import java.time.LocalDateTime;

public class AuthenticationTokenDTO {

    private long id;
    private String token;
    private UserDTO userDTO;
    private LocalDateTime expiredAt;
    private boolean isDelete;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
