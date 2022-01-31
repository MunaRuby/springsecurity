package com.example.classtask.filters;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JWTDataSource {
    private String secretKey;
    private String tokenPrefix;
    private Long expirationDate;
}
