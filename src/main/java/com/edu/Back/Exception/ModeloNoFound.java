package com.edu.Back.Exception;

public class ModeloNoFound extends RuntimeException{

    private static final long SerialVersionUID =1L;

    public ModeloNoFound(String msj){
        super(msj);
    }
}
