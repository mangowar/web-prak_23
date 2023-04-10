package webprak.webprak.tables;

import lombok.*;
import jakarta.persistence.*;
import org.yaml.snakeyaml.tokens.Token;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "person")
@Getter
@Setter
@ToString
@NoArgsConstructor(force = true)
@AllArgsConstructor

public class person implements TableEntity <Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "pesson_id")
    private Long person_id;

    @Column(nullable = false, name = "registration_date")
    @NonNull
    private Date registration_date;

    @Column(nullable = false, name = "role")
    @NonNull
    private String role;

    @Column(nullable = false, name = "login")
    @NonNull
    private String login;

    @Column(nullable = false, name = "password")
    @NonNull
    private String password;

    @Column(nullable = true, name = "profile_picture")
    private int profile_picture;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        person other = (person) o;
        return Objects.equals(person_id, other.person_id)
                && login.equals(other.login)
                && registration_date.equals(other.registration_date)
                && role.equals(other.role)
                && Objects.equals(profile_picture, other.profile_picture)
                && password.equals(other.password);
    }

    @Override
    public Long getId() {
        return this.person_id;
    }

    @Override
    public void setId(Long ID) {
        this.person_id = ID;
    }
};
