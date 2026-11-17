/*
 * @ (#) MemberShipService .java     1.0     11/17/2026
 * Copyright (c) 2026 IUH.All Rights Reserved.
 */
package fit.iuh.split_expense.service;

import fit.iuh.split_expense.entity.ExpenseGroup;
import fit.iuh.split_expense.entity.GroupMember;
import fit.iuh.split_expense.entity.User;
import fit.iuh.split_expense.entity.enums.Role;
import fit.iuh.split_expense.entity.enums.Status;
import fit.iuh.split_expense.repository.ExpenseGroupRepository;
import fit.iuh.split_expense.repository.GroupMemberRepository;
import fit.iuh.split_expense.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

/*
 *@description: this is a class to test the MemberShipService class
 *@author: Bao Nguyen
 *@Date: 11/17/2026
 *@version:      1.0
 */
@Service
@RequiredArgsConstructor
public class MemberShipService {
    private final GroupMemberRepository groupMemberRepository;
    private final ExpenseGroupRepository expenseGroupRepository;
    private final UserRepository userRepository;

    @Transactional
    public void addMemberToGroup(Long groupId,String userCode){
        ExpenseGroup expenseGroup = expenseGroupRepository.findById(groupId).orElseThrow(()->new RuntimeException("Không tìm thấy nhóm"));
        User user = userRepository.findByUserCode(userCode).orElseThrow(()->new RuntimeException("Không tìm thấy người dùng"));

        boolean exists = groupMemberRepository.existsByExpenseGroupAndUserAndStatus(expenseGroup,user, Status.ACTIVE);
        if (exists){
            throw new RuntimeException("Người dùng này đã là thành viên của nhóm!");
        }

        GroupMember groupMember = new GroupMember();
        groupMember.setExpenseGroup(expenseGroup);
        groupMember.setRole(Role.MEMBER);
        groupMember.setStatus(Status.ACTIVE);
        groupMember.setUser(user);
        groupMemberRepository.save(groupMember);
    }

    public void leaveGroup(Long groupId, Long userId){
        GroupMember membership = groupMemberRepository.findByExpenseGroupIdAndUserId(groupId, userId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tư cách thành viên trong nhóm này"));

        membership.setStatus(Status.LEFT);
        membership.setLeftAt(Instant.now());

        groupMemberRepository.save(membership);
    }
}
