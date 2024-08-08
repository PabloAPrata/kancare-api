package org.kan.kancare.boot.service;

import org.kan.kancare.boot.domain.Beneficiario;
import org.kan.kancare.boot.domain.Documento;

import java.util.List;

public interface DocumentoService {

    void salvar(Documento documento);

    void editar(Documento documento);

    void excluir(Long id);

    Documento buscarPorId(Long id);

    List<Documento> buscarDocumentosPorIdBeneficiario(Long id);

    List<Documento> buscarTodos();
}
