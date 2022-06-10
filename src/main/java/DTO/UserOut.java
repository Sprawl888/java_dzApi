package DTO;

import lombok.*;
import org.codehaus.jackson.map.annotate.JsonSerialize;
@Getter
@Setter
@JsonSerialize
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class UserOut{
	private long code;
	private String type;
	private String message;
}
