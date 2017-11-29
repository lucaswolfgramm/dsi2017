package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({ @NamedQuery(name= "todasOficinas", query = "SELECT o FROM Oficina o"),
				@NamedQuery(name= "todasOficinasNome", query = "SELECT o FROM Oficina o WHERE o.nomeReal LIKE :nome OR o.nomeFantasia LIKE :nome OR o.identificador LIKE :nome"),
			})

@Entity
public class Oficina {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long oid;
	private String identificador;
	private String nomeReal;
	private String nomeFantasia;
	private String cnpj;
	private String cep;
	private String endereco;
	private String cidade;
	private String estado;

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

	public String getNomeReal() {
		return nomeReal;
	}

	public void setNomeReal(String nomeReal) {
		this.nomeReal = nomeReal;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
