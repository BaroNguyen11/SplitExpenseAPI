/*
 * @ (#) UserService .java     1.0     11/17/2026
 * Copyright (c) 2026 IUH.All Rights Reserved.
 */
package fit.iuh.split_expense.service;

import fit.iuh.split_expense.dto.response.UserResponse;
import fit.iuh.split_expense.entity.User;
import fit.iuh.split_expense.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/*
 *@description: this is a class to test the UserService class
 *@author: Bao Nguyen
 *@Date: 11/17/2026
 *@version:      1.0
 */
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponse getUserByCode(String userCode){
        User user= userRepository.findByUserCode(userCode).orElseThrow(()->new RuntimeException("Không tìm thấy user"));
        return UserResponse.builder()
                .userCode(userCode)
                .fullName(user.getFullName())
                .username(user.getUsername())
                .build();
    }
}
