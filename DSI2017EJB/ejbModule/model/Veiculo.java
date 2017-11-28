package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({ @NamedQuery(name = "todosVeiculos", query = "SELECT v FROM Veiculo v"),
				@NamedQuery(name = "todosVeiculosNome", query = "SELECT v FROM Veiculo v WHERE v.nome LIKE :nome OR v.identificador like :nome OR v.placa like :nome OR v.chassis like :nome OR v.marca like :nome"),
				})
@Entity
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long oid;
	private String identificador;
	private String nome;
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	private Cliente cliente;
	private String marca;
	private String ano;
	private String chassis;
	private String placa;
	private String kmAtual;
	private String documentos;
	private String anexos;
	
	public long getOid() {
		return oid;
	}
	public void setOid(long oid) {
		this.oid = oid;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getChassis() {
		return chassis;
	}
	public void setChassis(String chassis) {
		this.chassis = chassis;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getKmAtual() {
		return kmAtual;
	}
	public void setKmAtual(String kmAtual) {
		this.kmAtual = kmAtual;
	}
	public String getDocumentos() {
		return documentos;
	}
	public void setDocumentos(String documentos) {
		this.documentos = documentos;
	}
	public String getAnexos() {
		return anexos;
	}
	public void setAnexos(String anexos) {
		this.anexos = anexos;
	}
}
