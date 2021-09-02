package com.mrojas.pruebas.mi_muebleria.models.users;

/**
 *
 * @author Manu
 */
public class Usuario {

    private String nombre;
    private String password;
    private Integer tipo;
    private Boolean activo;
    private UserRole rol;

    public Usuario() {
    }

    /**
     * Constructor para un nuevo usuario
     * 
     * @param nombre   Nombre del usuario
     * @param password Contraseña del usuario
     * @param tipo     Valor numérico que indidca el área al que pertenece el
     *                 usuario
     */

    public Usuario(String nombre, String password, Integer tipo) {
        this.nombre = nombre;
        this.password = password;
        this.tipo = tipo;
        asignarRol();
    }

    /**
     * Obtiene el nombre del usuario
     * 
     * @return nombre del usuario
     */

    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el nombre del usuario
     * 
     * @param nombre nombre del usuario
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la contraseña del usuario
     * 
     * @return Contraseña del usuario
     */

    public String getPassword() {
        return password;
    }

    /**
     * Cambia la contraseña del usuario
     * 
     * @param password Contraseña del usuario
     */

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Obtener el area al que pertenece el usuario
     * 
     * @return Area al que pertenece el usuario
     */

    public Integer getTipo() {
        asignarTipo();
        return tipo;
    }

    public UserRole getRol() {
        asignarRol();
        return rol;

    }

    public void setRol(UserRole rol) {
        this.rol = rol;
    }

    /**
     * Cambia el area al que pertenece el usuario
     * 
     * @param tipo Valor númerico del área al que pertenece el usuario
     */

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    /**
     * Verificar si el usuario ha sido cancelado
     * 
     * @return Retorna true o false dependiendo si se encuentra activo o no el
     *         usuario
     */

    public boolean isActivo() {
        return activo;
    }

    /**
     * Cambiar el estado del usuario, cancelarlo o activarlo
     * 
     * @param activo Valor que determina si el usuario está activo o no
     */

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    private void asignarRol() {
        if (this.tipo != null && this.rol == null) {
            System.out.println("asignando roles");
            switch (this.tipo) {
                case 1:
                    this.rol = UserRole.FABRICANTE;
                    break;
                case 2:
                    this.rol = UserRole.VENDEDOR;
                    break;
                case 3:
                    System.out.println("he asignado admin");
                    this.rol = UserRole.ADMIN;
                    break;
            }
        } else {
            System.out.println("vino nulo");
        }
    }

    private void asignarTipo() {
        if (this.rol != null && this.tipo == null) {
            switch (rol) {
                case FABRICANTE:
                    this.tipo = 1;
                    break;
                case VENDEDOR:
                    this.tipo = 2;
                    break;
                case ADMIN:
                    this.tipo = 3;
                    break;

            }
        }
    }

}
