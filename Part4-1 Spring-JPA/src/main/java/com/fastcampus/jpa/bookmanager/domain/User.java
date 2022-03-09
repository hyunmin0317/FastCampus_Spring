package com.fastcampus.jpa.bookmanager.domain;

import lombok.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data   // Getter, Setter, RequiredArgsConstructor, ToString, EqualsAndHashCode, Value
@Builder
public class User {
    @NonNull
    private String name;
    @NonNull
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
