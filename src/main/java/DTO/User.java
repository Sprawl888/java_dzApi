package DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Getter
@Setter
@JsonSerialize
@Builder
public class User{
	private String firstName;
	private String lastName;
	private String password;
	private int userStatus;
	private String phone;
	private Integer id;
	private String email;
	private String username;
}
