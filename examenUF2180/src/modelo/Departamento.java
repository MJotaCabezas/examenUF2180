package modelo;

import java.util.Objects;

public class Departamento {
	
	private int cod_departamento;
	private int cod_centro;
	private String tipo_dir;
	private int presupuesto;
	private String nombre;
	 
		
	
	public Departamento(int cod_departamento, int cod_centro, String tipo_dir, int presupuesto, String nombre) {
		
		this.cod_departamento = cod_departamento;
		this.cod_centro = cod_centro;
		this.tipo_dir = tipo_dir;
		this.presupuesto = presupuesto;
		this.nombre = nombre;
	}
	
	
	@Override
	public String toString() {
		return "Departamento [cod_departamento=" + cod_departamento + ", cod_centro=" + cod_centro + ", tipo_dir="
				+ tipo_dir + ", presupuesto=" + presupuesto + ", nombre=" + nombre + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(cod_departamento);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return cod_departamento == other.cod_departamento;
	}
	public int getCod_departamento() {
		return cod_departamento;
	}
	public void setCod_departamento(int cod_departamento) {
		this.cod_departamento = cod_departamento;
	}
	public int getCod_centro() {
		return cod_centro;
	}
	public void setCod_centro(int cod_centro) {
		this.cod_centro = cod_centro;
	}
	public String getTipo_dir() {
		return tipo_dir;
	}
	public void setTipo_dir(String tipo_dir) {
		this.tipo_dir = tipo_dir;
	}
	public int getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	
	


}
