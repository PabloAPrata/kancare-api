package org.kan.kancare.boot.service;

import org.kan.kancare.boot.domain.Beneficiario;
import org.kan.kancare.boot.domain.Documento;

import java.util.List;

public interface BeneficiarioService {

    void salvar(Beneficiario beneficiario);

    void editar(Beneficiario beneficiario);

    void excluir(Long id);

    Beneficiario buscarPorId(Long id);

    List<Documento> buscarDocumentosPorBeneficiario(Long id);

    List<Beneficiario> buscarTodos();
}
