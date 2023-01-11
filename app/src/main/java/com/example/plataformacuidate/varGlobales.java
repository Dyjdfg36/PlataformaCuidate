package com.example.plataformacuidate;

public class varGlobales {
    private static varGlobales instance;

    private static String _nombre="";
    private static String _papellido="";
    private static String _mapellido="";
    private static String _telefono="";
    private static String _email="";

    public String get_nombre(){
        return _nombre;
    }
    public void set_nombre(String _nombre){
        varGlobales._nombre=_nombre;
    }

    public String get_papellido(){
        return _papellido;
    }
    public void set_papellido(String _papellido){
        varGlobales._papellido=_papellido;
    }

    public String get_mapellido(){
        return _mapellido;
    }
    public void set_mapellido(String _mapellido){
        varGlobales._mapellido=_mapellido;
    }

    public String get_telefono(){
        return _telefono;
    }
    public void set_telefono(String _telefono){
        varGlobales._telefono=_telefono;
    }

    public String get_email(){
        return _email;
    }
    public void set_email(String _email){
        varGlobales._email=_email;
    }

    public static synchronized varGlobales getInstance(){
        if(instance==null){
            instance = new varGlobales();
        }
        return instance;
    }
}
