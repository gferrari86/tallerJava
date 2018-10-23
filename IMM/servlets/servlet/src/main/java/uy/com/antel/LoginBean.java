package uy.com.antel;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="loginBean")
@SessionScoped

public class LoginBean {

    private String usuario;
    private String shh;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getShh() {
        return shh;
    }

    public void setShh(String password) {
        this.shh = password;
    }

    public String validateUserLogin(){
        String navResult="";
        System.out.println("usuario: "+getUsuario()+" pass: "+getShh());
        if ((usuario.equals("user1")) && (shh.equals("pass1"))){
            navResult="success";
            return navResult;
        }
        else {

            navResult="failure";
            FacesMessage mensaje = new FacesMessage("Usuario/Password incorrectos");
            FacesContext.getCurrentInstance().addMessage("error",mensaje);
            return navResult;
        }

    }
}

