package G36_group_JPA_Assignment.JPA_Assingment.Model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString()
@EqualsAndHashCode(exclude = {"instructionId"})
@Entity

public class RecipeInstruction {

    @Id
    @GeneratedValue(generator =  "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")

    private String instructionId;
    private String instruction;

}
