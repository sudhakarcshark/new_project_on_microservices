package info.techsploit.Product_service.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
public class APIResponse {

    private int errorId;
    private String errorMsg;
    private Object data;

}
