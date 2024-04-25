package classesBase;
//Enzo Ferroni - RA: 10417100
//Leonardo Rodrigues - RA: 10418105
//Rafael Neves - RA: 10418316

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TipoConta")
public class TipoConta {
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long codTipoConta;
	
	@Column(nullable = false)
	private String descricao;
	@Column(nullable = false)
	private double limite;
	
	@OneToOne(mappedBy="conta")
	private Conta conta;
	
	//Getters & Setters
	public long getCodTipoConta() {
		return codTipoConta;
	}
	public void setCodTipoConta(long codTipoConta) {
		this.codTipoConta = codTipoConta;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getLimite() {
		return limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}

}
