//******************************************************
// Instituto Federal de São Paulo - Campus Sertãozinho
// Disciplina......: M3LPBD
// Programação de Computadores e Dispositivos Móveis
// Aluno...........: Victor Rubens da Silva Santos
//******************************************************
package br.edu.ifsp.srt.db.dao;

import br.edu.ifsp.srt.db.util.ConnectionUtils;
import br.edu.ifsp.srt.model.Subject;
import br.edu.ifsp.srt.model.enumerator.Period;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAO {

    // insere no banco de dados uma nova disciplina
    public static void insert(Subject subject) throws SQLException, Exception {
        String sql = "INSERT INTO "
                + "subject (name, workload, course, vacancies, period) "
                + "VALUES (?, ?, ?, ?, ?)";

        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = ConnectionUtils.getConnection();
            stmt = con.prepareStatement(sql);

            stmt.setString(1, subject.getName());
            stmt.setFloat(2, subject.getWorkload());
            stmt.setString(3, subject.getCourse());
            stmt.setInt(4, subject.getVacancies());
            stmt.setInt(5, subject.getPeriod().getValue());
            stmt.execute();
        } finally {
            ConnectionUtils.finalizeConnection(stmt, con);
        }
    }

    // atualiza no banco de dados uma disciplina
    public static void update(Subject subject) throws SQLException, Exception {
        String sql = "UPDATE subject SET name=?, workload=?, course=?, vacancies=?, period=? "
                + "WHERE (id=?)";

        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = ConnectionUtils.getConnection();
            stmt = con.prepareStatement(sql);

            stmt.setString(1, subject.getName());
            stmt.setFloat(2, subject.getWorkload());
            stmt.setString(3, subject.getCourse());
            stmt.setInt(4, subject.getVacancies());
            stmt.setInt(5, subject.getPeriod().getValue());
            stmt.setInt(6, subject.getId());

            stmt.execute();
        } finally {
            ConnectionUtils.finalizeConnection(stmt, con);
        }

    }

    // exclui do banco de dados uma disciplina
    public static void delete(Integer id) throws SQLException, Exception {

        String sql = "DELETE FROM subject "
                + "WHERE (id=?)";

        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = ConnectionUtils.getConnection();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } finally {
            ConnectionUtils.finalizeConnection(stmt, con);
        }
    }

    // Retorna uma lista de disciplinas persistidas no banco de dados
    public static List<Subject> list() throws SQLException, Exception {
        String sql = "SELECT * FROM subject";

        List<Subject> list = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet result = null;

        try {
            con = ConnectionUtils.getConnection();
            stmt = con.prepareStatement(sql);

            result = stmt.executeQuery();

            while (result.next()) {

                if (list == null) {
                    list = new ArrayList<Subject>();
                }

                Subject subject = new Subject();
                subject.setId(result.getInt("id"));
                subject.setName(result.getString("name"));
                subject.setWorkload(result.getFloat("workload"));
                subject.setCourse(result.getString("course"));
                subject.setVacancies(result.getInt("vacancies"));
                subject.setPeriod(Period.getEnum(result.getInt("period")));

                list.add(subject);
            }
        } finally {
            ConnectionUtils.finalizeConnection(result, stmt, con);
        }
        return list;
    }

    // Retorna uma lista de disciplinas persistidas no banco de dados, desde que no nome da disciplina seja parcial e/ou igual ao parametro
    public static List<Subject> searchByName(String value) throws SQLException, Exception {
        String sql = "SELECT * FROM subject WHERE (UPPER(name) LIKE UPPER(?) )";

        List<Subject> list = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet result = null;

        try {
            con = ConnectionUtils.getConnection();
            stmt = con.prepareStatement(sql);

            stmt.setString(1, "%" + value + "%");

            result = stmt.executeQuery();

            while (result.next()) {

                if (list == null) {
                    list = new ArrayList<Subject>();
                }

                Subject subject = new Subject();
                subject.setId(result.getInt("id"));
                subject.setName(result.getString("name"));
                subject.setWorkload(result.getFloat("workload"));
                subject.setCourse(result.getString("course"));
                subject.setVacancies(result.getInt("vacancies"));
                subject.setPeriod(Period.getEnum(result.getInt("period")));

                list.add(subject);
            }
        } finally {
            ConnectionUtils.finalizeConnection(result, stmt, con);
        }
        return list;
    }

    // Retorna uma lista de disciplinas persistidas no banco de dados, desde que o id da disciplina seja igual ao parametro
    public static Subject searchById(Integer id) throws SQLException, Exception {
        String sql = "SELECT * FROM subject WHERE (id=?)";

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet result = null;

        try {
            con = ConnectionUtils.getConnection();
            stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            result = stmt.executeQuery();

            if (result.next()) {

                Subject subject = new Subject();
                subject.setId(result.getInt("id"));
                subject.setName(result.getString("name"));
                subject.setWorkload(result.getFloat("workload"));
                subject.setCourse(result.getString("course"));
                subject.setVacancies(result.getInt("vacancies"));
                subject.setPeriod(Period.getEnum(result.getInt("period")));

                return subject;
            }
        } finally {
            ConnectionUtils.finalizeConnection(result, stmt, con);
        }
        return null;
    }
}
