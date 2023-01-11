package com.example.plataformacuidate;
import java.sql.Connection;
import java.sql.DriverManager;
public class clsConexion {
    Connection conexion=null;

    public Connection conexionBD(){
        try{
            Class.forName("org.postgresql.Driver");
            conexion=DriverManager.getConnection("jdbc:postgresql://192.168.90.95:5432/appCuidate","postgres","20151130");
        }
        catch (Exception er){
            System.err.println(er.getMessage());
        }
        return conexion;
    }

    protected void cerrar_conexion(Connection con)throws Exception{
        con.close();
    }
}
