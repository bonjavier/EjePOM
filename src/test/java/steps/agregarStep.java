package steps;

import net.thucydides.core.annotations.Step;
import pageobjects.agregarpage;

public class agregarStep {

    agregarpage.agregarPage agregandoPc;


    @Step
    public void abrirUrl(){

        agregandoPc.open();//metodo de serenity abre la URL por defecto
    }
    public void clicAgregarpc(){
        agregandoPc.Agregarpc();
    }

    public void llenarFormulario(String varComputador, String varFechainicio, String varFechaFin, int varCompania) throws InterruptedException {

        agregandoPc.DiligenciarFormulario(varComputador, varFechainicio, varFechaFin, varCompania);
    }
    public void alerta(){
        agregandoPc.AlertaExitosa();
    }
    public void alerta2(){
        agregandoPc.AlertaFallida();
    }

}
