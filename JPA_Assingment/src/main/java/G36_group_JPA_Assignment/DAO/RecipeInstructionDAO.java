package G36_group_JPA_Assignment.DAO;

import G36_group_JPA_Assignment.Model.RecipeInstruction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeInstructionDAO extends JpaRepository<RecipeInstruction, String> {
}
