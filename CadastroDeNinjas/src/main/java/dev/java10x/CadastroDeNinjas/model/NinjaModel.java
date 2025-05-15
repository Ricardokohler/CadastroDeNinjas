package dev.java10x.CadastroDeNinjas.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ninjaId;
    private String nome;
    private String aldeia;
    private int idade;
    private String elemento;
    private String imgUrl;


    @ManyToOne //UM NINJA TEM UMA UNICA MISSAO
    @JoinColumn(name = "Missao_ id") // chave estrangeira
    private MissoesModel missoes;
}
