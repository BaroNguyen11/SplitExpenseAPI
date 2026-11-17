/*
 * @ (#) GroupMember .java     1.0     11/16/2026
 * Copyright (c) 2026 IUH.All Rights Reserved.
 */
package fit.iuh.split_expense.entity;

import fit.iuh.split_expense.entity.enums.Role;
import fit.iuh.split_expense.entity.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

/*
 *@description: this is a class to test the GroupMember class
 *@author: Bao Nguyen
 *@Date: 11/16/2026
 *@version:      1.0
 */
@Getter
@Setter
@Entity
@Table(name = "group_members")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "joined_at", nullable = false)
    private Instant joinedAt;
    @Column(name = "left_at")
    private Instant leftAt;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private ExpenseGroup expenseGroup;

    @OneToMany(mappedBy = "groupMember")
    private List<ExpenseSplit> expenseSplits;

    @OneToMany(mappedBy = "groupMember")
    private List<Expense> expenses;

    @OneToMany(mappedBy = "payer")
    private List<Settlement> payers;
    @OneToMany(mappedBy = "receiver")
    private List<Settlement> receivers;
    @PrePersist
    protected void onCreated(){
        joinedAt = Instant.now();
        if (status == null) {
            status = Status.ACTIVE;
        }
    }
}
