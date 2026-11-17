package fit.iuh.split_expense.repository;

import fit.iuh.split_expense.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
