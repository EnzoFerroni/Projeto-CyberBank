package bank.cyber.CyberBank.Entidades;
//Enzo Ferroni - RA: 10417100
//Leonardo Rodrigues - RA: 10418105
//Rafael Neves - RA: 10418316

import java.util.SortedSet;
import java.util.TreeSet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinTable;

@Entity
@Table(name = "Conta")
public class Conta {
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long numConta;
	
	@Column(nullable = false)
	private int agencia;
	
	@Column(nullable = false)
	private int senha;
	@Column(nullable = false)
	private double saldo;
	
	@ManyToOne
	@JoinColumn(name="cpf", nullable=false)
	private Cliente cliente;
	
	
	//Getters & Setters
	public long getNumConta() {
		return numConta;
	}
	public void setNumConta(long numConta) {
		this.numConta = numConta;
	}
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	
}
