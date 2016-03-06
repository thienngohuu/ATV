/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managebean.login;

import entity.Account;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import stub.AccountStub;

/**
 *
 * @author stom2
 */
@ManagedBean
@RequestScoped
public class LoginmanageBean {

    private String pwd;
    private String msg;
    private String user;
    private AccountStub stub;

    /**
     * Creates a new instance of LoginmanageBean
     */
    public LoginmanageBean() {
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    //validate login
    public String validateUsernamePassword() {
        Account account = new Account(user, pwd);
        boolean valid = stub.login(account);
        if (valid) {
            account = stub.findByName(user);
            if (account.getStatus()) {
                HttpSession session = SessionBean.getSession();
                session.setAttribute("username", user);
                if (1 == account.getIdrole().getIdrole()) {
                    return "admin";

                } else if (2 == account.getIdrole().getIdrole()) {
                    return "mod";
                } else {
                    return "member";
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN,
                                "Username is banned",
                                "Please contant mod"));
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "login";
        }
        return "login";
    }
//logout event, invalidate session

    public String logout() {
        HttpSession session = SessionBean.getSession();
        session.invalidate();
        return "login";
    }
}
