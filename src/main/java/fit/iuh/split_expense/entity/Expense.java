/*
 * @ (#) Expense .java     1.0     11/16/2026
 * Copyright (c) 2026 IUH.All Rights Reserved.
 */
package fit.iuh.split_expense.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

/*
 *@description: this is a class to test the Expense class
 *@author: Bao Nguyen
 *@Date: 11/16/2026
 *@version:      1.0
 */
@Getter
@Setter
@Entity
@Table(name = "expenses")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @Column(name = "total_amount",nullable = false)
    private BigDecimal totalAmount;
    @Column(name = "expense_date",nullable = false)
    private Instant expenseDate;
    @Column(name = "created_at",nullable = false)
    private Instant createdAt;


    @OneToMany(mappedBy = "expense")
    private List<ExpenseSplit> expenseSplits;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private ExpenseGroup expenseGroup;

    @ManyToOne
    @JoinColumn(name = "payer_member_id")
    private GroupMember groupMember;

    @PrePersist
    protected void onUpdated(){
        createdAt = Instant.now();
    }
}
