/*
 * @ (#) UserController .java     1.0     11/17/2026
 * Copyright (c) 2026 IUH.All Rights Reserved.
 */
package fit.iuh.split_expense.controller;

import fit.iuh.split_expense.dto.response.UserResponse;
import fit.iuh.split_expense.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 *@description: this is a class to test the UserController class
 *@author: Bao Nguyen
 *@Date: 11/17/2026
 *@version:      1.0
 */
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

//    @GetMapping
//    public ResponseEntity<List<UserResponse>> getAllUsers(){
//        return userService.
//    }

    @GetMapping("/{userCode}")
    public ResponseEntity<UserResponse> getUserByUserCode(@PathVariable String userCode){
        return ResponseEntity.ok(userService.getUserByCode(userCode));
    }
}
