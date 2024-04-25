package classesBase;
//Enzo Ferroni - RA: 10417100
//Leonardo Rodrigues - RA: 10418105
//Rafael Neves - RA: 10418316

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.ManyToMany;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Conta")
public class Conta {
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long numConta;
	private int agencia;
	
	@Column(nullable = false)
	private int senha;
	@Column(nullable = false)
	private double saldo;
	
	@ManyToOne
	@JoinColumn(name="cpf", nullable=false)
	private Cliente cliente;
	
	@OneToMany(mappedBy="cartao")
	private Cartao cartao;
	
	@OneToOne(mappedBy="tipoConta")
	private TipoConta tipoConta;
	
	@ManyToMany
	@JoinTable(
			  name = "Conta_Transacao", 
			  joinColumns = @JoinColumn(name = "numConta"), 
			  inverseJoinColumns = @JoinColumn(name = "codTransacao"))
	private Transacao transacao;
	
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
	public Cartao getCartao() {
		return cartao;
	}
	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
	public TipoConta getTipoConta() {
		return tipoConta;
	}
	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}
	public Transacao getTransacao() {
		return transacao;
	}
	public void setTransacao(Transacao transacao) {
		this.transacao = transacao;
	}
	
	
}
