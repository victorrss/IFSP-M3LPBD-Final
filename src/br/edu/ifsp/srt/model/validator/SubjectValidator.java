//******************************************************
// Instituto Federal de São Paulo - Campus Sertãozinho
// Disciplina......: M3LPBD
// Programação de Computadores e Dispositivos Móveis
// Aluno...........: Victor Rubens da Silva Santos
//******************************************************
package br.edu.ifsp.srt.model.validator;

import br.edu.ifsp.srt.exception.SubjectException;
import br.edu.ifsp.srt.model.Subject;

public class SubjectValidator {

    // valida a instancia.
    public static void validate(Subject subject) throws SubjectException {
        if (subject == null) {
            throw new SubjectException("A instancia da disciplina é inválida");
        }

        if (subject.getName() == null || subject.getName().trim().isEmpty()) {
            throw new SubjectException("Nome da disciplina não fornecido");
        }

        if (subject.getCourse() == null || subject.getCourse().trim().isEmpty()) {
            throw new SubjectException("Nome do curso não fornecido");
        }

        if (subject.getVacancies() == null || subject.getVacancies() < 0) {
            throw new SubjectException("Quantidade de vagas inválida");
        }

        if (subject.getWorkload() == null || subject.getWorkload() < 1) {
            throw new SubjectException("Carga horária inválida");
        }
    }
}
