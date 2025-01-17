package belajarspringrestfulapi.restful.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TokenResponse {
    private String token;
    private Long expiredAt;
}
