package org.kan.kancare.boot.service;

import jakarta.persistence.EntityNotFoundException;
import org.kan.kancare.boot.dao.BeneficiarioDao;
import org.kan.kancare.boot.domain.Beneficiario;
import org.kan.kancare.boot.domain.Documento;
import org.kan.kancare.boot.dto.BeneficiarioResposta;
import org.kan.kancare.boot.dto.DocumentoResposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service @Transactional
public class BeneficiarioServiceImpl implements BeneficiarioService {

    @Autowired
    private BeneficiarioDao dao;

    @Override
    public void salvar(Beneficiario beneficiario) {
        dao.save(beneficiario);
    }

    @Override
    public void editar(Long id, Beneficiario beneficiarioAtualizado) {
        Beneficiario beneficiario = buscarPorId(id);
        if (beneficiario == null) {
            throw new EntityNotFoundException("Beneficiário não encontrado.");
        }

        beneficiario.setNome(beneficiarioAtualizado.getNome());
        beneficiario.setTelefone(beneficiarioAtualizado.getTelefone());
        beneficiario.setDataNascimento(beneficiarioAtualizado.getDataNascimento());
        beneficiario.setDocumentos(beneficiarioAtualizado.getDocumentos());

        dao.update(beneficiario);
    }

    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Override @Transactional(readOnly = true)
    public List<DocumentoResposta> buscarDocumentosPorBeneficiario(Long id) {
        Beneficiario beneficiaryById = dao.findById(id);

        List<Documento> listaDocumentos = beneficiaryById.getDocumentos();

        return listaDocumentos.stream()
                .map(documento -> DocumentoResposta.builder()
                        .tipoDocumento(documento.getTipoDocumento())
                        .descricao(documento.getDescricao())
                        .dataInclusao(documento.getDataInclusao())
                        .dataAtualizacao(documento.getDataAtualizacao())
                        .build())
                .collect(Collectors.toList());
    }

    @Override @Transactional(readOnly = true)
    public Beneficiario buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override @Transactional(readOnly = true)
    public List<BeneficiarioResposta> buscarTodos() {

        List<Beneficiario> listaBeneficiarios = dao.findAll();

        return listaBeneficiarios.stream()
                .map(beneficiario -> BeneficiarioResposta.builder()
                        .nome(beneficiario.getNome())
                        .telefone(beneficiario.getTelefone())
                        .dataNascimento(beneficiario.getDataNascimento())
                        .dataInclusao(beneficiario.getDataInclusao())
                        .dataAtualizacao(beneficiario.getDataInclusao())
                        .build())
                .collect(Collectors.toList());

    }
}
