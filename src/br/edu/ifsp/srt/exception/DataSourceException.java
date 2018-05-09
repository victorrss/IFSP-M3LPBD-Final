//******************************************************
// Instituto Federal de São Paulo - Campus Sertãozinho
// Disciplina......: M3LPBD
// Programação de Computadores e Dispositivos Móveis
// Aluno...........: Victor Rubens da Silva Santos
//******************************************************
package br.edu.ifsp.srt.exception;

public class DataSourceException extends Exception {

    // especialização de exception para o banco de dados
    public DataSourceException(String message) {
        super(message);
    }

}
