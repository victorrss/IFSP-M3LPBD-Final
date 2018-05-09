//******************************************************
// Instituto Federal de São Paulo - Campus Sertãozinho
// Disciplina......: M3LPBD
// Programação de Computadores e Dispositivos Móveis
// Aluno...........: Victor Rubens da Silva Santos
//******************************************************
package br.edu.ifsp.srt.service;

import br.edu.ifsp.srt.db.dao.SubjectDAO;
import br.edu.ifsp.srt.exception.DataSourceException;
import br.edu.ifsp.srt.exception.SubjectException;
import br.edu.ifsp.srt.model.Subject;
import br.edu.ifsp.srt.model.validator.SubjectValidator;
import java.util.ArrayList;
import java.util.List;

public class SubjectService {

    // instancia do sigleton
    private static final SubjectService INSTANCE = new SubjectService();

    // construtor em branco
    private SubjectService() {
    }

    // retorna o sigleton
    public static SubjectService getInstance() {
        return INSTANCE;
    }

    // serviço que após validar irá invocar o DAO a inserir a disciplina no banco
    public void insert(Subject subject) throws SubjectException, DataSourceException {
        SubjectValidator.validate(subject);

        try {
            SubjectDAO.insert(subject);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados");
        }
    }

    // serviço que retorna o select para a view
    public List<Subject> list() throws SubjectException, DataSourceException {
        List<Subject> list = new ArrayList<>();
        try {
            list = SubjectDAO.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados");
        }
        return list;
    }

    // serviço que retorna uma disciplina para a view
    public Subject show(Integer id) throws SubjectException, DataSourceException {
        Subject subject = null;
        try {
            subject = SubjectDAO.searchById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados");
        }
        return subject;
    }

    // serviço que deleta uma disciplina
    public void delete(Integer id) throws SubjectException, DataSourceException {
        try {
            SubjectDAO.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados");
        }
    }

}
