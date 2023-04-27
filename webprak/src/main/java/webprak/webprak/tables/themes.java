package webprak.webprak.tables;
import javax.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "themes")
@Getter
@Setter
@ToString
@NoArgsConstructor(force = true)
@AllArgsConstructor

public class themes implements TableEntity<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "theme_id", nullable = false)
    private Long theme_id;

    @Column(name = "theme_name", nullable = false)
    @NonNull
    private String theme_name;

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

    @Override
    public Long getId() {
        return this.theme_id;
    }

    @Override
    public void setId(Long ID) {
        this.theme_id = ID;
    }


};
