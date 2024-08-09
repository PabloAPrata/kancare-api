package org.kan.kancare.boot.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeneficiarioResposta {

    String nome;
    String telefone;
    LocalDate dataNascimento;
    LocalDate dataInclusao;
    LocalDate dataAtualizacao;

}
