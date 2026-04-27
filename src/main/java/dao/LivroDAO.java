package dao;

import domain.*;
import java.sql.*;
import java.util.*;

public class LivroDAO extends GenericDAO {

    public void insert(Livro l) {
        try (Connection c = getConnection();
             PreparedStatement s = c.prepareStatement(
                     "INSERT INTO Livro(titulo,autor,ano,preco,editora_id) VALUES(?,?,?,?,?)")) {

            s.setString(1, l.getTitulo());
            s.setString(2, l.getAutor());
            s.setInt(3, l.getAno());
            s.setFloat(4, l.getPreco());
            s.setLong(5, l.getEditora().getId());
            s.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public List<Livro> getAll() {
        List<Livro> lista = new ArrayList<>();

        try (Connection c = getConnection();
             Statement s = c.createStatement();
             ResultSet r = s.executeQuery("SELECT * FROM Livro l JOIN Editora e ON l.editora_id=e.id")) {

            while(r.next()) {
                Editora ed = new Editora(
                        r.getLong("e.id"),
                        r.getString("cnpj"),
                        r.getString("nome")
                );

                lista.add(new Livro(
                        r.getLong("l.id"),
                        r.getString("titulo"),
                        r.getString("autor"),
                        r.getInt("ano"),
                        r.getFloat("preco"),
                        ed
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }

        return lista;
    }

    public void delete(Long id) {
        try (Connection c = getConnection();
             PreparedStatement s = c.prepareStatement("DELETE FROM Livro WHERE id=?")) {

            s.setLong(1, id);
            s.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
}