/*
 * @ (#) MembershipController .java     1.0     11/17/2026
 * Copyright (c) 2026 IUH.All Rights Reserved.
 */
package fit.iuh.split_expense.controller;

import fit.iuh.split_expense.service.MemberShipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 *@description: this is a class to test the MembershipController class
 *@author: Bao Nguyen
 *@Date: 11/17/2026
 *@version:      1.0
 */
@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class MembershipController {

    private final MemberShipService membershipService;

    @PostMapping("/{groupId}/members")
    public ResponseEntity<String> addMember(
            @PathVariable Long groupId,
            @RequestParam String userCode) {
        membershipService.addMemberToGroup(groupId, userCode);
        return ResponseEntity.ok("Thêm thành viên vào nhóm thành công!");
    }

    @PatchMapping("/{groupId}/leave")
    public ResponseEntity<String> leaveGroup(
            @PathVariable Long groupId,
            @RequestParam Long userId) {
        membershipService.leaveGroup(groupId, userId);
        return ResponseEntity.ok("Đã rời nhóm thành công!");
    }
}