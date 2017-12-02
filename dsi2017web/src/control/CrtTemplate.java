package control;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import ejb.UsuarioEJBLocal;
import model.Usuario;

@ManagedBean(name = "crtTemplate")
@ViewScoped
public class CrtTemplate {
	@EJB
	private UsuarioEJBLocal usuarioEJB;
	private Usuario model = new Usuario();

	public void validar() {
		Usuario usuario = usuarioEJB.validaUsuario(model.getUsuario(), model.getSenha());

		if (usuario != null) {
			FacesContext fc = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
			session.setAttribute("USUARIO_LOGADO", usuario);
			RequestContext.getCurrentInstance().execute("PF('dlgLogin').hide()");
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Usuário e/ou Senha Incorretos"));
		}
	}

	@PostConstruct
	public void abrirLogin() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
		if (session.getAttribute("USUARIO_LOGADO") == null) {
			RequestContext.getCurrentInstance().execute("PF('dlgLogin').show()");
		}
	}

	public void dologoff() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
		session.removeAttribute("USUARIO_LOGADO");
		ExternalContext ec = fc.getExternalContext();
		try {
			ec.redirect("template.xhtml");
		} catch (IOException ex) {
		}
	}

	public void report() throws IOException {
		// ...

		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		externalContext.redirect("http://localhost:8080/DSI2017WEB/printreport?reportName=lista&reportType=PDF");
	}

	public Usuario getModel() {
		return model;
	}

	public void setModel(Usuario model) {
		this.model = model;
	}

}