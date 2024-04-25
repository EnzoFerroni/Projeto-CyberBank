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
@Table(name = "Cartao")
public class Cartao {
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
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
	@JoinColumn(name="agencia", nullable=false)
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
