package app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table ( name = "tb_proprietario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Proprietario {

    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private int idade;
}
