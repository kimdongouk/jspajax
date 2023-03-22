package membership;

public class UserTest {

	public static void main(String[] args) {
		String name = "hong";
		int age = 11;
		String email = "email";
		
		UserDTO user = new UserDTO(name,age,email);
		UserDTO user2 = UserDTO.builder().name(name).age(age).build();
		System.out.println(user2.getName());
		System.out.println(user2.getAge());
		System.out.println(user2.getEmail());
	}

}
