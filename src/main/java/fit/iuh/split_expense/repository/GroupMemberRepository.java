package fit.iuh.split_expense.repository;

import fit.iuh.split_expense.entity.GroupMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupMemberRepository extends JpaRepository<GroupMember, Long> {
}
