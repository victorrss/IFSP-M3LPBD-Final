//******************************************************
// Instituto Federal de São Paulo - Campus Sertãozinho
// Disciplina......: M3LPBD
// Programação de Computadores e Dispositivos Móveis
// Aluno...........: Victor Rubens da Silva Santos
//******************************************************
package br.edu.ifsp.srt.model.enumerator;

public enum Period {
    Matutino(0),
    Vespertino(1),
    Noturno(2);

    private final int value;

    // encapsulamento
    private Period(int value) {
        this.value = value;
    }

    // encapsulamento
    public int getValue() {
        return value;
    }

    // conversão de inteiro para um corresponde do Enum
    public static Period getEnum(int value) {
        for (Period e : Period.values()) {
            if (e.getValue() == value) {
                return e;
            }
        }
        return Period.Matutino;
    }
}
