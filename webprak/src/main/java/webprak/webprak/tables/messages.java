package webprak.webprak.tables;
import lombok.*;
import javax.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "messages")
@Getter
@Setter
@ToString
public class messages implements TableEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "message_id")
    private Long message_id;

    @OneToOne
    @JoinColumn(name = "topic_id", nullable = false)
    private topics topic_id;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private person person_id;

    @Column(name = "date", nullable = false)
    @NonNull
    private Date date;

    @Column(name = "message_text", nullable = false)
    @NonNull
    private String message_text;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        messages other = (messages) o;
        return Objects.equals(message_id, other.message_id)
                && Objects.equals(topic_id, other.topic_id)
                && Objects.equals(person_id, other.person_id)
                && date.equals(other.date)
                && message_text.equals(other.message_text);
    }

    @Override
    public Long getId() {
        return this.message_id;
    }

    @Override
    public void setId(Long ID) {
        this.message_id = ID;
    }
}
