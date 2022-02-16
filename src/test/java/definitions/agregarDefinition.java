package definitions;


import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;
import steps.agregarStep;

public class agregarDefinition {

    @Steps
    agregarStep llamaragregarstep;

    @Dado("^que el usuario ingresa a la pagina para agregar un pc$")
    public void que_el_usuario_ingresa_a_la_pagina_para_agregar_un_pc() {
        llamaragregarstep.abrirUrl();
        llamaragregarstep.clicAgregarpc();

    }

    @Cuando("^diligencia el formulario ingresando el nombre \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", (\\d+)\"$")
    public void diligencia_el_formulario_ingresando_el_nombre(String varComputador, String varFechainicio, String varFechaFin, int varCompania) throws InterruptedException {
        llamaragregarstep.llenarFormulario(varComputador, varFechainicio, varFechaFin, varCompania);
    }

    @Entonces("^se crea un nuevo pc$")
    public void se_crea_un_nuevo_pc() {
        llamaragregarstep.alerta();
    }


    //fallido
    @Cuando("^diligencia el formulario ingresando campos erroneos \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", (\\d+)\"$")
    public void diligencia_el_formulario_ingresando_campos_erroneos(String varComputador, String varFechainicio, String varFechaFin, int varCompania) throws InterruptedException {
        llamaragregarstep.llenarFormulario(varComputador, varFechainicio, varFechaFin, varCompania);
    }


    @Entonces("^no permite registrar porque son valores erroneos$")
    public void no_permite_registrar_porque_son_valores_erroneos() {
        llamaragregarstep.alerta2();
    }

}
