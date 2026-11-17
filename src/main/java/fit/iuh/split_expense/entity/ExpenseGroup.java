/*
 * @ (#) ExpenseGroup .java     1.0     11/16/2026
 * Copyright (c) 2026 IUH.All Rights Reserved.
 */
package fit.iuh.split_expense.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

/*
 *@description: this is a class to test the ExpenseGroup class
 *@author: Bao Nguyen
 *@Date: 11/16/2026
 *@version:      1.0
 */
@Getter
@Setter
@Entity
@Table(name = "expense_groups")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpenseGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Column(name = "created_at",nullable = false)
    private Instant createdAt;

    @OneToMany(mappedBy = "expenseGroup")
    private List<GroupMember> groupMembers;

    @OneToMany(mappedBy = "expenseGroup")
    private List<Expense> expenses;

    @OneToMany(mappedBy = "expenseGroup")
    private List<Settlement> settlements;
    @PrePersist
    protected void onUpdated(){
        createdAt = Instant.now();
    }
}
