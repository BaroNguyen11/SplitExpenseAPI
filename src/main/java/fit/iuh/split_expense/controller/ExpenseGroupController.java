/*
 * @ (#) ExpenseGroupController .java     1.0     11/17/2026
 * Copyright (c) 2026 IUH.All Rights Reserved.
 */
package fit.iuh.split_expense.controller;

import fit.iuh.split_expense.dto.request.CreateGroupRequest;
import fit.iuh.split_expense.dto.response.GroupResponse;
import fit.iuh.split_expense.service.ExpenseGroupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 *@description: this is a class to test the ExpenseGroupController class
 *@author: Bao Nguyen
 *@Date: 11/17/2026
 *@version:      1.0
 */
@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class ExpenseGroupController {
    private final ExpenseGroupService expenseGroupService;

    @PostMapping
    public ResponseEntity<GroupResponse> createGroup(
            @RequestParam Long userId,
            @Valid @RequestBody CreateGroupRequest request
            ){
        GroupResponse groupResponse = expenseGroupService.create(userId,request);
        return new ResponseEntity<>(groupResponse, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<GroupResponse> getGroupDetails(@PathVariable Long id){
    GroupResponse groupResponse = expenseGroupService.getGroupById(id);
    return ResponseEntity.ok(groupResponse);
    }

}
