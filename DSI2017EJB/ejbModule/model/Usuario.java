package model;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
		@NamedQuery(name = "todosUsuarios", query = "SELECT u FROM Usuario u"),
		@NamedQuery(name = "todosUsuariosNome", query = "SELECT u FROM Usuario u WHERE u.usuario LIKE :nome OR u.identificador LIKE :nome"),
		@NamedQuery(name = "validausuario", query = "SELECT u FROM Usuario u WHERE u.usuario = :usuario AND u.senha = :senha"),})

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long oid;
	private String identificador;
	private String usuario;
	private String senha;
	private String message;
	
	public long getOid() {
		return oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	 
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
     
    public void saveMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage("Acesso Liberado",  "Login Efetuado com:" + usuario) );
        context.addMessage(null, new FacesMessage("Acesso Negado !!!", "Usuário"+ usuario + "não Encontrado"));
    }

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
}