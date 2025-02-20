package br.com.guerin.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Table(name = "cattles", schema = "public")
public class Cattle extends AbstractEntity{

    @Getter
    @Setter
    @NotNull
    @Column(name = "earring", nullable = false, unique=true)
    private Long earring;

    @Getter
    @Setter
    @Column(name = "weight", nullable = false)
    private Float weight;

    @Getter @Setter
    @JoinColumn(name = "specie_id", nullable = true)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Specie specie;

    @Getter @Setter
    @JoinColumn(name = "farm_id", nullable = false)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Farm farm;

    @Getter @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Getter @Setter
    @Column(name = "father", nullable = true)
    private Long father;

    @Getter @Setter
    @Column(name = "mother", nullable = true)
    private Long mother;

    public Cattle(Long earring) {
        this.earring = earring;
    }

    public Cattle(Long earring, Float weight, Specie specie, Farm farm, Gender gender, Long father, Long mother) {
        this.earring = earring;
        this.weight = weight;
        this.specie = specie;
        this.farm = farm;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
    }

    public Cattle(
            long earring,
            float weight,
            String nelore,
            String fazenda_generica,
            Gender male,
            long father,
            long mother
    ) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cattle cattle = (Cattle) o;
        return Objects.equals(earring, cattle.earring) && Objects.equals(weight, cattle.weight) && Objects.equals(specie, cattle.specie) && Objects.equals(farm, cattle.farm) && gender == cattle.gender && Objects.equals(father, cattle.father) && Objects.equals(mother, cattle.mother);
    }

    @Override
    public int hashCode() {
        return Objects.hash(earring, weight, specie, farm, gender, father, mother);
    }
}