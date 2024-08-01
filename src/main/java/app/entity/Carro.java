package app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table ( name = "/tbcarrs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Carro {

    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String ano;

    @ManyToOne(cascade = CascadeType.ALL)//SALVANDO EM CASCATA "todas operações ENTITY VÃO SALVAR"
    @JsonIgnoreProperties("carros")
    private Marca marca;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable( name = "carro_proprietario")
    @JsonIgnoreProperties("proprietarios")
    private List<Proprietario> proprietarios;
}
