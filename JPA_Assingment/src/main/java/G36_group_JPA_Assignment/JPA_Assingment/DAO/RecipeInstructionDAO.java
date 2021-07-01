package G36_group_JPA_Assignment.JPA_Assingment.DAO;

import G36_group_JPA_Assignment.JPA_Assingment.Model.RecipeInstruction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeInstructionDAO extends JpaRepository<RecipeInstruction, String> {
}
