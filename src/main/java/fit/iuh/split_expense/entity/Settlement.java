/*
 * @ (#) Settlement .java     1.0     11/16/2026
 * Copyright (c) 2026 IUH.All Rights Reserved.
 */
package fit.iuh.split_expense.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

/*
 *@description: this is a class to test the Settlement class
 *@author: Bao Nguyen
 *@Date: 11/16/2026
 *@version:      1.0
 */
@Getter
@Setter
@Entity
@Table(name = "settlements")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Settlement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;
    @Column(name = "settled_at",nullable = false)
    private Instant settledAt;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private ExpenseGroup expenseGroup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payer_member_id", nullable = false)
    private GroupMember payer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_member_id", nullable = false)
    private GroupMember receiver;
    @PrePersist
    protected void onUpdated(){
        settledAt = Instant.now();
    }
}
