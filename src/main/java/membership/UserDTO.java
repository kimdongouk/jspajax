package membership;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class UserDTO {
	private String name;
	private int age;
	private String email;
}
