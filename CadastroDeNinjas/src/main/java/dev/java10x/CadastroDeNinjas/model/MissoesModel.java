package dev.java10x.CadastroDeNinjas.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long MissaoId;
    private String nome;
    private String dificuldade;

    //@OneToMany uma missao tem um ou vario ninjas
    @OneToMany(mappedBy = "missoes")//a coluna que se relaciona
    private List <NinjaModel> ninja;

}
