package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import java.util.regex.Matcher;

public class DAO {

	private String dirver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://172.20.0.2:3306/db_phone_book";
	private String user = "user";
	private String password = "password";

	private Connection conectar() {

		try {

			Class.forName(dirver);
			Connection connection = DriverManager.getConnection(url, user, password);

			return connection;
		} catch (Exception e) {

			System.out.println(e);

			return null;
		}

	}

	public Map<Boolean, String> inserirContato(Contato contato) {
		String create = "INSERT INTO contato (nome,fone,email) VALUES (?,?,?)";

		Map<Boolean, String> resp = new HashMap<Boolean, String>();

		try {

			Connection connection = conectar();

			PreparedStatement statement = connection.prepareStatement(create);

			statement.setString(1, contato.getNome());
			statement.setString(2, contato.getFone());
			statement.setString(3, contato.getEmail());

			statement.executeUpdate();

			connection.close();

			resp.put(Boolean.FALSE, "");

			return resp;

		} catch (SQLIntegrityConstraintViolationException e) {

			System.out.println(e);

			resp.put(Boolean.TRUE, dadoDuplicado(e.getMessage()));

			return resp;
		} catch (Exception e) {
			System.out.println(e);
			resp.put(Boolean.FALSE, "");
			return resp;
		}
	}

	public List<Contato> listarContatos() {

		List<Contato> contatos = new ArrayList<Contato>();

		String read = "SELECT * FROM contato ORDER BY nome";

		try {

			Connection connection = conectar();

			PreparedStatement statement = connection.prepareStatement(read);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);

				contatos.add(new Contato(id, nome, fone, email));
			}

			connection.close();

			return contatos;

		} catch (Exception e) {

			System.out.println(e);

			return null;
		}
	}

	public Contato selecionarContato(String id) {
		String read = "SELECT * FROM contato WHERE id=?";

		try {

			Connection connection = conectar();

			PreparedStatement statement = connection.prepareStatement(read);

			statement.setString(1, id);

			ResultSet rSet = statement.executeQuery();

			rSet.next();
			Contato dadosContato = new Contato(rSet.getString(1), rSet.getString(2), rSet.getString(3),
					rSet.getString(4));

			connection.close();

			return dadosContato;

		} catch (Exception e) {
			System.out.println(e);

			return null;
		}

	}

	public void editarContato(Contato contato) {
		String update = "UPDATE contato SET nome=?, fone=?,email=? WHERE id=?";

		try {
			Connection connection = conectar();

			PreparedStatement statement = connection.prepareStatement(update);

			statement.setString(1, contato.getNome());
			statement.setString(2, contato.getFone());
			statement.setString(3, contato.getEmail());
			statement.setString(4, contato.getId());

			statement.executeUpdate();

			connection.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void deletarContato(String id) {
		String delete = "DELETE FROM contato WHERE id=?";

		try {
			Connection connection = conectar();

			PreparedStatement statement = connection.prepareStatement(delete);

			statement.setString(1, id);

			statement.executeUpdate();

			connection.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private String dadoDuplicado(String msgErro) {

		Pattern pattern = Pattern.compile("'(.*?)'");
		Matcher matcher = pattern.matcher(msgErro);
		if (matcher.find()) {
			return matcher.group(1);
		} else {
			return null;
		}
	}
}
