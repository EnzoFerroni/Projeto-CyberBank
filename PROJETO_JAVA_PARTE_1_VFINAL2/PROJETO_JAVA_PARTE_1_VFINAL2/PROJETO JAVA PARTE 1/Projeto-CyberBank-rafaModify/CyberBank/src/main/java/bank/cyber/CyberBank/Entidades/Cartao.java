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

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "Cartao")
public class Cartao {
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long numCartao;
	
	@Column(nullable = false)
	private int pin;
	@Column(nullable = false)
	private String dataValidade;
	@Column(nullable = false)
	private String bandeira;
	@Column(nullable = false)
	private String tipoCartao;
	
	@ManyToOne
	@JoinColumn(name="numConta", nullable=false)
	private Conta conta;
	
	//Getters & Setters
	public long getNumCartao() {
		return numCartao;
	}
	public void setNumCartao(long numCartao) {
		this.numCartao = numCartao;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public String getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}
	public String getBandeira() {
		return bandeira;
	}
	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}
	public String getTipoCartao() {
		return tipoCartao;
	}
	public void setTipoCartao(String tipoCartao) {
		this.tipoCartao = tipoCartao;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}

}
