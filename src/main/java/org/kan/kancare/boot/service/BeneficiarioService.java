package org.kan.kancare.boot.service;

import org.kan.kancare.boot.domain.Beneficiario;
import org.kan.kancare.boot.domain.Documento;
import org.kan.kancare.boot.dto.BeneficiarioResposta;
import org.kan.kancare.boot.dto.DocumentoResposta;

import java.util.List;

public interface BeneficiarioService {

    void salvar(Beneficiario beneficiario);

    void editar(Long id, Beneficiario beneficiario);

    void excluir(Long id);

    Beneficiario buscarPorId(Long id);

    List<DocumentoResposta> buscarDocumentosPorBeneficiario(Long id);

    List<BeneficiarioResposta> buscarTodos();
}
