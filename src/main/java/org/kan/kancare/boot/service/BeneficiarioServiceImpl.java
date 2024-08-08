package org.kan.kancare.boot.service;

import org.kan.kancare.boot.dao.BeneficiarioDao;
import org.kan.kancare.boot.domain.Beneficiario;
import org.kan.kancare.boot.domain.Documento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @Transactional(readOnly = false)
public class BeneficiarioServiceImpl implements BeneficiarioService {

    @Autowired
    private BeneficiarioDao dao;

    @Override
    public void salvar(Beneficiario beneficiario) {
        System.out.println(beneficiario.toString());
        dao.save(beneficiario);
    }

    @Override
    public void editar(Beneficiario beneficiario) {
        dao.update(beneficiario);
    }

    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Override
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
