package model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries({ @NamedQuery(name = "todosOrcamentos", query = "SELECT g FROM Orcamento g") })

@Entity
public class Orcamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long oid;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "PedidoId")
	private ArrayList<Item> colItensPedido = new ArrayList<Item>();

	private String identificador;
	@Column(length = 1000)
	private String nome;
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	private Cliente cliente;
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	private Veiculo veiculo;
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	private Item item;
	private int Custo;
	private String dtIniPlan;
	private String dtFimPlan;
	private String dtIniExec;
	private String dtFimExec;
	private String dtEmissao;
	private String documento;
	private String anexo;
	
	
	public long getOid() {
		return oid;
	}
	public void setOid(long oid) {
		this.oid = oid;
	}
	public ArrayList<Item> getColItensPedido() {
		return colItensPedido;
	}
	public void setColItensPedido(ArrayList<Item> colItensPedido) {
		this.colItensPedido = colItensPedido;
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
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getCusto() {
		return Custo;
	}
	public void setCusto(int custo) {
		Custo = custo;
	}
	public String getDtIniPlan() {
		return dtIniPlan;
	}
	public void setDtIniPlan(String dtIniPlan) {
		this.dtIniPlan = dtIniPlan;
	}
	public String getDtFimPlan() {
		return dtFimPlan;
	}
	public void setDtFimPlan(String dtFimPlan) {
		this.dtFimPlan = dtFimPlan;
	}
	public String getDtIniExec() {
		return dtIniExec;
	}
	public void setDtIniExec(String dtIniExec) {
		this.dtIniExec = dtIniExec;
	}
	public String getDtFimExec() {
		return dtFimExec;
	}
	public void setDtFimExec(String dtFimExec) {
		this.dtFimExec = dtFimExec;
	}
	public String getDtEmissao() {
		return dtEmissao;
	}
	public void setDtEmissao(String dtEmissao) {
		this.dtEmissao = dtEmissao;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getAnexo() {
		return anexo;
	}
	public void setAnexo(String anexo) {
		this.anexo = anexo;
	}
}
