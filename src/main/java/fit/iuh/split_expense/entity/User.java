/*
 * @ (#) User .java     1.0     11/16/2026
 * Copyright (c) 2026 IUH.All Rights Reserved.
 */
package fit.iuh.split_expense.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;
import java.util.Random;

/*
 *@description: this is a class to test the User class
 *@author: Bao Nguyen
 *@Date: 11/16/2026
 *@version:      1.0
 */
@Getter
@Setter
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 8)
    private String userCode;
    private String username;
    private String fullName;
    private String password;
    private Instant createdAt;

    @OneToMany(mappedBy = "user")
    private List<GroupMember> groupMembers;

    @PrePersist
    protected void onCreated(){
        createdAt = Instant.now();

    }
    private String generateRandom8DigitCode() {
        Random random = new Random();
        int number = 10000000 + random.nextInt(90000000);
        return String.valueOf(number);
    }
}
