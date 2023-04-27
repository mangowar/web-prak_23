package webprak.webprak.tables;
import javax.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "topics")
@Getter
@Setter
@ToString
public class topics implements TableEntity<Long> {

    @ManyToMany(mappedBy = "topicsSet")
    private Set<person> personSet;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id", nullable = false)
    private Long topic_id;

    @Column(name = "topic_name", nullable = false)
    @NonNull
    private String topic_name;

    @ManyToOne(targetEntity = themes.class)
    @JoinColumn(name = "theme_id", nullable = false)
    private themes theme_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        topics other = (topics) o;
        return Objects.equals(theme_id, other.theme_id)
                && topic_name.equals(other.topic_name)
                && Objects.equals(topic_id, other.topic_id);
    }

    @Override
    public Long getId() {
        return this.topic_id;
    }

    @Override
    public void setId(Long ID) {
        this.topic_id = ID;
    }


};
