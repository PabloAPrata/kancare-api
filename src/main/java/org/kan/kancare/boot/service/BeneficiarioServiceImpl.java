package org.kan.kancare.boot.service;

import jakarta.persistence.EntityNotFoundException;
import org.kan.kancare.boot.dao.BeneficiarioDao;
import org.kan.kancare.boot.domain.Beneficiario;
import org.kan.kancare.boot.domain.Documento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public List<Documento> buscarDocumentosPorBeneficiario(Long id) {
        Beneficiario beneficiaryById = dao.findById(id);
        return beneficiaryById.getDocumentos();
    }

    @Override @Transactional(readOnly = true)
    public Beneficiario buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override @Transactional(readOnly = true)
    public List<Beneficiario> buscarTodos() {
        return dao.findAll();
    }
}
