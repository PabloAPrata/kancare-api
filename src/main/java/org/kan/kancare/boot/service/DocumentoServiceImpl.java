package org.kan.kancare.boot.service;

import org.kan.kancare.boot.dao.DocumentoDao;
import org.kan.kancare.boot.domain.Documento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @Transactional(readOnly = false)
public class DocumentoServiceImpl implements DocumentoService {

    @Autowired
    private DocumentoDao dao;

    @Override
    public void salvar(Documento documento) {
        dao.save(documento);
    }

    @Override
    public void editar(Documento documento) {
        dao.update(documento);
    }

    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Override @Transactional(readOnly = true)
    public Documento buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override @Transactional(readOnly = true)
    public List<Documento> buscarTodos() {
        return dao.findAll();
    }
}
