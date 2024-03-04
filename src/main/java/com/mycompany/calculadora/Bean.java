package com.mycompany.calculadora;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "ctl")
@SessionScoped
public class Bean implements Serializable {

    public Bean() {
        setVisor("0");
        setOp(null);
        setModo(false);//começo o sistema desativando qualquer modo de operação.
    }
    
    private double n1;
    private double n2;
    private String op;
    private String visor;
    private Boolean modo;//fiz uma variavel para quando usuário acionar alguma operação aritmética (true) ou não (false);
        
    public void btSoma(ActionEvent ae){
        setN1(Double.parseDouble(getVisor()));
        setOp("+");
        setModo(true);//habilito modo de operação
    }
    
    public void btC(ActionEvent ae){
        setVisor("0");
        setOp(null);
        setN1(0);
        setN2(0);
        setModo(false);
    }
    
    public void btIgual(ActionEvent ae){
        setN2(Double.parseDouble(getVisor()));
        switch(getOp()){
            case "+":
                setVisor(String.valueOf(getN1()+getN2()));
            break;    
        }
    }
    
    public void bt7(ActionEvent ae){        
       String n = "7";
       if (getVisor().equals("0") || getModo()==true){
           setVisor(n);
           setModo(false);
       }else{
           String prov = getVisor();
           prov += n;
           setVisor(prov);
           setModo(false);//desativo modo de operação
       }     
    }//bt7
    
     public void bt8(ActionEvent ae){ 
          String n = "8";
       if (getVisor().equals("0") || getModo()==true){
           setVisor(n);
           setModo(false);
       }else{
           String prov = getVisor();
           prov += n;
           setVisor(prov);
           setModo(false);//desativo modo de operação
       }    
    }//bt8
   
    /////////////////GET SET
     public String getVisor() {
        return visor;
    }

    public void setVisor(String visor) {    
        this.visor = visor;
    }

    public double getN1() {
        return n1;
    }

    public void setN1(double n1) {
        this.n1 = n1;
    }

    public double getN2() {
        return n2;
    }

    public void setN2(double n2) {
        this.n2 = n2;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public Boolean getModo() {
        return modo;
    }

    public void setModo(Boolean modo) {
        this.modo = modo;
    }
    
    
    
}//class
