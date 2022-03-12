package com.fastcampus.jpa.bookmanager.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data   // Getter, Setter, RequiredArgsConstructor, ToString, EqualsAndHashCode, Value
@Builder
@Entity
@EntityListeners(value = { AuditingEntityListener.class, UserEntityListener.class })
//@Table(name = "user", indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User implements Auditable {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

//    @Column(name = "crtdat", nullable = false, unique = true)
    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;

//    @Column(insertable = false)
    @LastModifiedDate
    private LocalDateTime updatedAt;

//    @Transient      // DB에 반영 X
//    private String testData;

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Address> address;

//    listener

//    insert
//    @PrePersist
//    public void prePersist() {
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = LocalDateTime.now();
//    }
//    @PostPersist

//    select
//    @PreUpdate
//    public void preUpdate() {
//        this.updatedAt = LocalDateTime.now();
//    }
//    @PostLoad

//    update
//    @PreUpdate
//    @PostUpdate

//    remove
//    @PreRemove
//    @PostRemove
}
