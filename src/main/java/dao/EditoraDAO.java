package dao;

import domain.Editora;
import java.sql.*;
import java.util.*;

public class EditoraDAO extends GenericDAO {

    public void insert(Editora e) {
        String sql = "INSERT INTO Editora (cnpj, nome) VALUES (?, ?)";

        try (Connection c = getConnection();
             PreparedStatement s = c.prepareStatement(sql)) {

            s.setString(1, e.getCNPJ());
            s.setString(2, e.getNome());
            s.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void update(Editora e) {
        String sql = "UPDATE Editora SET cnpj=?, nome=? WHERE id=?";

        try (Connection c = getConnection();
             PreparedStatement s = c.prepareStatement(sql)) {

            s.setString(1, e.getCNPJ());
            s.setString(2, e.getNome());
            s.setLong(3, e.getId());
            s.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void delete(Long id) {
        String sql = "DELETE FROM Editora WHERE id=?";

        try (Connection c = getConnection();
             PreparedStatement s = c.prepareStatement(sql)) {

            s.setLong(1, id);
            s.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Editora> getAll() {
        List<Editora> lista = new ArrayList<>();

        try (Connection c = getConnection();
             Statement s = c.createStatement();
             ResultSet r = s.executeQuery("SELECT * FROM Editora")) {

            while (r.next()) {
                lista.add(new Editora(
                        r.getLong("id"),
                        r.getString("cnpj"),
                        r.getString("nome")
                ));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return lista;
    }

    public Editora get(Long id) {
        Editora e = null;

        try (Connection c = getConnection();
             PreparedStatement s = c.prepareStatement("SELECT * FROM Editora WHERE id=?")) {

            s.setLong(1, id);
            ResultSet r = s.executeQuery();

            if (r.next()) {
                e = new Editora(
                        r.getLong("id"),
                        r.getString("cnpj"),
                        r.getString("nome")
                );
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return e;
    }
}