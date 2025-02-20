package br.com.guerin.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Table(name = "parameters", schema = "public")
public class Parameter {
    @Id
    @Getter
    @Setter
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Getter @Setter
    @NotNull
    @Column(name = "included", nullable = true)
    private LocalDateTime included;

    @Getter @Setter
    @Column(name = "description", nullable = false)
    private String description;

    @Getter @Setter
    @Column(name = "value", nullable = false)
    private String value;
}
