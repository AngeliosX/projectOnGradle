package com.example.user_service.entity;

import com.example.user_service.validator.annotation.Email;
import com.example.user_service.validator.annotation.NameUserNotEmpty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NameUserNotEmpty
    @Column(name = "name")
    @Size(min = 6, message = "at least 6 characters")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "lastname")
    private String lastname;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @Column(name = "password")
    @Size(min = 5, message = "it isn't less than 5 signs, including special symbols %#&*@")
    private String password;

    @PrePersist
    public void saveDefaultPass() {
        if (password == null) {
            password = "Flag123@";
        }
    }


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "links_users_roles",
            joinColumns = {@JoinColumn(name = "id_user", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "id_roles", referencedColumnName = "id")}
    )
    Set<Roles> rolesSet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return 69;
    }


}
