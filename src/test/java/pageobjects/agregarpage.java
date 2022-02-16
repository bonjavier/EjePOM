package pageobjects;

import static org.hamcrest.MatcherAssert.assertThat;
import cucumber.api.java.Before;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

public class agregarpage {
    @DefaultUrl("http://computer-database.gatling.io/computers?f=computer")
    public class agregarPage extends PageObject {

        @Before
        public void setup() {
            OnStage.setTheStage(new OnlineCast()); //antes de hacer cualquier cosa se utiliza esta clase para simular un actor
        }

        @FindBy(id = "add") //boton agregar nuevo computador
        public WebElementFacade btnagregar;   //se agrega la variable del elemento


        @FindBy(id = "name")
        public WebElementFacade Ingresartextonombre;

        @FindBy(id="introduced")
        public WebElementFacade IngresartextoIntroduced;

        @FindBy(id="discontinued")
        public WebElementFacade Ingresartextodiscontinued;

        @FindBy(id="company")
        public WebElementFacade Seleccionarcreador;

        @FindBy(xpath = "//*[@id=\"main\"]/form/div/input")
        public WebElementFacade BtnCrearpc;

        @FindBy(xpath = "//*[@id=\"main\"]/div[1]")
        public WebElementFacade AlertaCreacion;

        @FindBy(xpath = "//*[@id=\"main\"]/form/fieldset/div[1]/div/span")
        public WebElementFacade AlertaFalloCampoNombrePC;

        @FindBy(xpath = "//*[@id=\"main\"]/form/fieldset/div[2]/div/span")
        public WebElementFacade AlertaFalloCampoFechaRegistro;

        @FindBy(xpath = "//*[@id=\"main\"]/form/fieldset/div[3]/div/span")
        public WebElementFacade AlertaFalloCampoFechaVencimiento;


        public void Agregarpc() { //se crea un metodo para ejecutar la acción de dar el clic
            btnagregar.click();
        }

        public void DiligenciarFormulario (String varComputador, String varFechainicio, String varFechaFin, int varCompania) throws InterruptedException {
            Ingresartextonombre.sendKeys(varComputador);
            IngresartextoIntroduced.sendKeys(varFechainicio);
            Ingresartextodiscontinued.sendKeys(varFechaFin);

            Seleccionarcreador.selectByIndex(varCompania);
            Thread.sleep(2000);//agregar tiempo de espera
            BtnCrearpc.click();


        }

        public void AlertaExitosa (){
            String VarElemento = AlertaCreacion.getText();//guardamos el texto de la notificación en la variable para luego compararla
            assertThat(VarElemento,containsText("Done"));
        }

        public void AlertaFallida (){
            String VarElementoFalloCampoNombrePC = AlertaFalloCampoNombrePC.getText();//guardamos el texto de la notificación en la variable para luego compararla
            assertThat(VarElementoFalloCampoNombrePC,containsText("Failed"));

            String VarElementoFalloCampoFechaRegistro = AlertaFalloCampoFechaRegistro.getText();//guardamos el texto de la notificación en la variable para luego compararla
            assertThat(VarElementoFalloCampoFechaRegistro,containsText("Failed"));

            String VarElementoFalloCampoFechaVencimiento = AlertaFalloCampoFechaVencimiento.getText();//guardamos el texto de la notificación en la variable para luego compararla
            assertThat(VarElementoFalloCampoFechaVencimiento,containsText("Failed"));

        }





    }
}
