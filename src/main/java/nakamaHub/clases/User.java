package nakamaHub.clases;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;
import nakamaHub.superClass.BaseEntity;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table (name="users")
public class User extends BaseEntity {

    @Column (name = "username", nullable = false, unique = true, length = 30)
    private String username;

    @Column(name="birthday", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Past(message = "La fecha de cumpleaños debe ser anterior a la fecha actual")
    private LocalDate birthday;

    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Size(min=8)
    @Column(name="password", nullable = false, length = 80)
    private String password;

    @Column(name = "profile_picture", columnDefinition = "TEXT")
    private String profilePicture;

    @Column(name="description")
    private String description;


}
