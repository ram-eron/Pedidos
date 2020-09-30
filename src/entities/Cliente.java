package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {
	
	String nome;
	String email;
	Date birthDate;
	
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	
	public Cliente() {
	}
	
	public Cliente(String nome, String email, String birthDate) throws ParseException {
		this.nome = nome;
		this.email = email;
		this.birthDate = df.parse(birthDate);
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) throws ParseException {
		this.birthDate = df.parse(birthDate);
	}
	
	@Override
	public String toString() {
		return " nome= " + nome + " " + df.format(birthDate) + " email = " + email;
	}

	
}
