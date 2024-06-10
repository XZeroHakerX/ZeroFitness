package model;

import java.io.Serializable;
import java.util.Objects;

/**
 * <h2>Class Usuario</h2> <i>Contiene toda la información del usuario incluido
 * método para creación mediante Singleton. </i>
 * 
 * @version v0.1 10/06/2024
 * @author Zero Haker
 * 
 */

public class Usuario implements Serializable, Comparable<Usuario> {

	private static final long serialVersionUID = 1L;

	private String name;
	private String userName;
	private String password;
	private Integer age;
	private Double weight;
	private Double height;

	public Usuario(String name, String userName, String password, Integer age, Double weight, Double height)
			throws NameException {
		setName(name);
		setUserName(userName);
		setPassword(password);
		setAge(age);
		setWeight(weight);
		setHeight(height);
	}

	private String getName() {
		return name;
	}

	private String getUserName() {
		return userName;
	}

	private String getPassword() {
		return password;
	}

	private Integer getAge() {
		return age;
	}

	private Double getWeight() {
		return weight;
	}

	private Double getHeight() {
		return height;
	}

	private void setName(String name) throws NameException {

		if (name == null || name.isBlank())
			throw new NameException();

		this.name = name;
	}

	private void setUserName(String userName) {
		this.userName = userName;
	}

	private void setPassword(String password) {
		this.password = password;
	}

	private void setAge(Integer age) {
		this.age = age;
	}

	private void setWeight(Double weight) {
		this.weight = weight;
	}

	private void setHeight(Double height) {
		this.height = height;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, height, name, password, userName, weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(age, other.age) && Objects.equals(height, other.height)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(userName, other.userName) && Objects.equals(weight, other.weight);
	}

	@Override
	public int compareTo(Usuario o) {

		return 0;
	}

}
