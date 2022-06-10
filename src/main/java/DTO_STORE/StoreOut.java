package DTO_STORE;
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

public class StoreOut {
    private String id;
    private int quantity;
    private int petId;
    private String shipDate;
    private boolean complete;
    private String status;
    private long code;
    private String message;
    private String type;
}



