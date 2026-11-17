/*
 * @ (#) ExpenseSplit .java     1.0     11/16/2026
 * Copyright (c) 2026 IUH.All Rights Reserved.
 */
package fit.iuh.split_expense.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


/*
 *@description: this is a class to test the ExpenseSplit class
 *@author: Bao Nguyen
 *@Date: 11/16/2026
 *@version:      1.0
 */
@Getter
@Setter
@Entity
@Table(name = "expense_splits")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpenseSplit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "group_member_id")
    private GroupMember groupMember;

    @ManyToOne
    @JoinColumn(name = "expense_id")
    private Expense expense;
}
