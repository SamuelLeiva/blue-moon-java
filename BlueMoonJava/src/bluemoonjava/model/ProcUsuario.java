/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluemoonjava.model;

import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class ProcUsuario {
    public static void BuscarUsuario(String email, String password)  throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call getCredentials (?, ?)}");
        entrada.setString(1,email);
        entrada.setString(2,password);
        entrada.execute();
    }
}
