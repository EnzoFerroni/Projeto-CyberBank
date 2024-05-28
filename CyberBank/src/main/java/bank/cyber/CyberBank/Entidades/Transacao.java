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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Transacao")
public class Transacao {
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long codTransacao;
	
	@Column(nullable = false)
	private long contaAtual;
	
	@Column(nullable = false)
	private String dataHora;
	@Column(nullable = false)
	private double valor;
	
	@Column(nullable = false)
	private long conta;
	
	//Getters & Setters
	
	public long getCodTransacao() {
		return codTransacao;
	}
	public void setCodTransacao(long codTransacao) {
		this.codTransacao = codTransacao;
	}

	public String getDataHora() {
		return dataHora;
	}
	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public long getConta() {
		return conta;
	}
	public void setConta(long conta) {
		this.conta = conta;
	}
	public long getContaAtual() {
		return contaAtual;
	}
	public void setContaAtual(long contaAtual) {
		this.contaAtual = contaAtual;
	}
	
}
