/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrojas.pruebas.mi_muebleria.services;

import com.mrojas.pruebas.mi_muebleria.models.users.UserRole;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Manu
 */
public class LoginServiceSession {

    public Optional<String> getUsername(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username != null) {
            return Optional.of(username);
        }
        return Optional.empty();
    }

    public Optional<UserRole> getUserRole(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserRole userRole = (UserRole) session.getAttribute("userRole");
        if (userRole != null) {
            return Optional.of(userRole);
        }
        return Optional.empty();
    }

    public boolean getEstado(HttpServletRequest request) {
        HttpSession session = request.getSession();
        boolean estado = false;
        if (session.getAttribute("userState") != null) {
            estado = Boolean.parseBoolean(session.getAttribute("userState").toString());
        }
        return estado;
    }

    public boolean isUserSession(HttpServletRequest request, String user) {
        boolean estado = false;
        String userSession = getUsername(request).get();
        if (userSession != null) {
            estado = user.equals(userSession);
        }
        return estado;
    }

}
