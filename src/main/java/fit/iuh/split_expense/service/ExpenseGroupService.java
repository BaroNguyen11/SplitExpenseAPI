/*
 * @ (#) ExpenseGroupService .java     1.0     11/17/2026
 * Copyright (c) 2026 IUH.All Rights Reserved.
 */
package fit.iuh.split_expense.service;

import fit.iuh.split_expense.dto.request.CreateGroupRequest;
import fit.iuh.split_expense.dto.response.GroupResponse;
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

/*
 *@description: this is a class to test the ExpenseGroupService class
 *@author: Bao Nguyen
 *@Date: 11/17/2026
 *@version:      1.0
 */
@Service
@RequiredArgsConstructor
public class ExpenseGroupService {
    private final UserRepository userRepository;
    private final ExpenseGroupRepository expenseGroupRepository;
    private final GroupMemberRepository groupMemberRepository;

    @Transactional
    public GroupResponse create(Long userId,CreateGroupRequest request){
        User creator = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("Không tìm thấy user"));

        ExpenseGroup group = new ExpenseGroup();
        group.setName(request.getName());
        group.setDescription(request.getDescription());
        ExpenseGroup savedGroup = expenseGroupRepository.save(group);

        GroupMember ownerMembership = new GroupMember();
        ownerMembership.setUser(creator);
        ownerMembership.setExpenseGroup(savedGroup);
        ownerMembership.setRole(Role.OWNER);
        ownerMembership.setStatus(Status.ACTIVE);
        groupMemberRepository.save(ownerMembership);

        if (request.getMembers() != null && !request.getMembers().isEmpty()){
            for (Long memberId : request.getMembers()){
                if (memberId.equals(userId)){
                    continue;
                }
                User memberUser = userRepository.findById(memberId).orElseThrow(()-> new RuntimeException("Không tìm thấy user"));
                GroupMember member = new GroupMember();
                member.setUser(memberUser);
                member.setExpenseGroup(savedGroup);
                member.setRole(Role.MEMBER);
                member.setStatus(Status.ACTIVE);
                groupMemberRepository.save(member);
            }
        }
        return GroupResponse.builder()
                .id(savedGroup.getId())
                .name(savedGroup.getName())
                .description(savedGroup.getDescription())
                .createdAt(savedGroup.getCreatedAt())
                .build();
    }
    public GroupResponse getGroupById(Long id){
        ExpenseGroup expenseGroup = expenseGroupRepository.findById(id).orElseThrow(()-> new RuntimeException("Không tìm thấy nhóm"));

        return GroupResponse.builder()
                .id(expenseGroup.getId())
                .name(expenseGroup.getName())
                .description(expenseGroup.getDescription())
                .createdAt(expenseGroup.getCreatedAt())
                .build();
    }
}
