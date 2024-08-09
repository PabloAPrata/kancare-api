package org.kan.kancare.boot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocumentoResposta {

    String tipoDocumento;
    String descricao;
    LocalDate dataInclusao;
    LocalDate dataAtualizacao;
}
