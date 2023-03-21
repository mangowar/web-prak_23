package webprak.webprak.tables;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "themes")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class themes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "theme_id", nullable = false)
    private int theme_id;

    @Column(name = "theme_name", nullable = false)
    @NonNull
    private String theme_name;

//    @Column(name = "theme_creator", nullable = false)
    @ManyToOne
    @JoinColumn(name = "theme_creator", nullable = false)
    private person theme_creator;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        themes other = (themes) o;
        return Objects.equals(theme_id, other.theme_id)
                && theme_name.equals(other.theme_name)
                && Objects.equals(theme_creator, other.theme_creator);
    }
};
