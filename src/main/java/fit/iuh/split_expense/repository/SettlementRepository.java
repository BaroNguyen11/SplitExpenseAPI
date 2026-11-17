package fit.iuh.split_expense.repository;

import fit.iuh.split_expense.entity.Settlement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettlementRepository extends JpaRepository<Settlement, Long> {
}
