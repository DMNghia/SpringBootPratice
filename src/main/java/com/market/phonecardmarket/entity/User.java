package com.market.phonecardmarket.entity;

import com.market.phonecardmarket.enums.UserStage;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;
    private String username;

    @Column(columnDefinition = "VARCHAR(255) COLLATE utf8_bin")
    private String password;

    @Column(unique = true)
    private String email;
    private String phone;
    private String avatar;
    private double balance;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role", referencedColumnName = "id")
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(name = "stage")
    private UserStage stage;

    @CreatedDate
    @Column(
            name = "created_at"
    )
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(
            name = "updated_at"
    )
    private LocalDateTime updatedAt;
}
