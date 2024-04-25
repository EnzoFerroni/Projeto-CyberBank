package classesBase;
//Enzo Ferroni - RA: 10417100
//Leonardo Rodrigues - RA: 10418105
//Rafael Neves - RA: 10418316

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Transacao")
public class Transacao {
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long codTransacao;
	
	@Column(nullable = false)
	private String tipo;
	@Column(nullable = false)
	private String dataHora;
	@Column(nullable = false)
	private double valor;
	
	@ManyToMany(mappedBy="contaTransacao")
	private Conta conta;
	
	//Getters & Setters
	
	public long getCodTransacao() {
		return codTransacao;
	}
	public void setCodTransacao(long codTransacao) {
		this.codTransacao = codTransacao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
}
