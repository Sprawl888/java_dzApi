package DTO_STORE;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Getter
@Setter
@JsonSerialize
@Builder

public class Store {
	private String id;
	private int quantity;
	private int petId;
	private String shipDate;
	private boolean complete;
	private String status;

}

