package fit.iuh.split_expense.repository;

import fit.iuh.split_expense.entity.ExpenseGroup;
import fit.iuh.split_expense.entity.GroupMember;
import fit.iuh.split_expense.entity.User;
import fit.iuh.split_expense.entity.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupMemberRepository extends JpaRepository<GroupMember, Long> {
    boolean existsByExpenseGroupAndUserAndStatus(ExpenseGroup expenseGroup, User user, Status status);
    Optional<GroupMember> findByExpenseGroupIdAndUserId(Long groupId, Long userId);
    }
