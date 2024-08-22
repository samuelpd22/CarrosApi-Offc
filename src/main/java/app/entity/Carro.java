package app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "Nome não pode ser nulo")
    private String nome;

    @NotNull(message = "ano não pode ser nulo")
    private int ano;

    @ManyToOne(cascade = CascadeType.ALL)//Salvar todos os dados das entidades em cascata
    @JsonIgnoreProperties("carros")
    private Marca marca;

    @ManyToMany
    @JsonIgnoreProperties("carros")
    @JoinTable( name = "carro_acessorio")
    private List<Acessorio> acessorios;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable( name = "carro_proprietario")
    @JsonIgnoreProperties("proprietarios")
    private List<Proprietario> proprietarios;
}
