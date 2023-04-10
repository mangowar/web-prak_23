package webprak.webprak.tables;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "topic_creators")
@Getter
@Setter
@ToString
public class topic_creators implements TableEntity<Long>{
    @JoinColumn(name = "person_id", nullable = false)
    @NonNull
    @ManyToOne
    @Id
    private person theme_id;

    @JoinColumn(name = "topic_id", nullable = false)
    @NonNull
    @ManyToOne
    @Id
    private topics topic_id;

    @Column(name = "id", nullable = false)
    @NonNull
    @Id
    private Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        topic_creators other = (topic_creators) o;
        return Objects.equals(theme_id, other.theme_id)
                && Objects.equals(topic_id, other.topic_id);
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long ID) {
        this.id = ID;
    }
}
