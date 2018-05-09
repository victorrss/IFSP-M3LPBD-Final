//******************************************************
// Instituto Federal de São Paulo - Campus Sertãozinho
// Disciplina......: M3LPBD
// Programação de Computadores e Dispositivos Móveis
// Aluno...........: Victor Rubens da Silva Santos
//******************************************************
package br.edu.ifsp.srt.model;

import br.edu.ifsp.srt.model.enumerator.Period;

public class Subject {

    private Integer id;
    private String name, course;
    private Period period;
    private Float workload;
    private Integer vacancies;

    // encapsulamento
    public String getName() {
        return name;
    }

    // encapsulamento
    public void setName(String name) {
        this.name = name;
    }

    // encapsulamento
    public String getCourse() {
        return course;
    }

    // encapsulamento
    public void setCourse(String course) {
        this.course = course;
    }

    // encapsulamento
    public Float getWorkload() {
        return workload;
    }

    // encapsulamento
    public void setWorkload(Float workload) {
        this.workload = workload;
    }

    // encapsulamento
    public Integer getId() {
        return id;
    }

    // encapsulamento
    public void setId(Integer id) {
        this.id = id;
    }

    // encapsulamento
    public Integer getVacancies() {
        return vacancies;
    }

    // encapsulamento
    public void setVacancies(Integer vacancies) {
        this.vacancies = vacancies;
    }

    // encapsulamento
    public Period getPeriod() {
        return period;
    }

    // encapsulamento
    public void setPeriod(Period period) {
        this.period = period;
    }

}
