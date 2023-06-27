package epn.edu.ec.restaurantefm.infrastructure.InputAdapter.Http;

import epn.edu.ec.restaurantefm.Domain.Plato;
import epn.edu.ec.restaurantefm.infrastructure.InputPort.PlatosInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class PlatoAPI {

    @Autowired
    PlatosInputPort platosInputPort;

    @GetMapping("/")
    public String inicio(Model model) {
        try {
            model.addAttribute("platos", platosInputPort.obtenerPlatos());
            return "inicio";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/platos")
    public String getallplatos(Model model){
        try {
            model.addAttribute("platos",platosInputPort.obtenerPlatos());
            return "plato/index";
        }catch (Exception e){
            model.addAttribute("error",e.toString());
            return "error";
        }
    }

    @GetMapping("/detalle/{id}")
    public String detallePlato(Model model, @PathVariable("id") long id) {
        try {
            Plato plato = (Plato) platosInputPort.buscarPlatoPorId(id);
            model.addAttribute("plato", plato);
            return "plato/detalle";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }


    @GetMapping("/formulario/plato/{id}")
    public String formularioPlato(Model model, @PathVariable("id") long id) {
        try {
            if(id==0){
                Plato plato =new Plato();
                plato.setId(0L);
                plato.setPuntuacion(0);
                model.addAttribute("plato",plato);
                System.out.println("form a nuevo plato");
            }else{
                model.addAttribute("plato",platosInputPort.buscarPlatoPorId(id));
                System.out.println("form actualizar");

            }
            return "plato/formulario";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/formulario/plato/{id}")
    public String guardarPlato(
            @Valid @ModelAttribute("plato") Plato plato,
            BindingResult result,
            Model model,
            @PathVariable("id") long id
            ){
        try {

            if(result.hasErrors()){
                return "plato/formulario";
            }
            System.out.println(plato.getId());
            if(plato.getId()==0 ){
                plato.setPuntuacion(0);
                System.out.println("entra a agregar");
                platosInputPort.agregarPlato(plato);
            }
            else {
                System.out.println("entra a actualizar");
                platosInputPort.actualizarPlato(plato);
            }
            return "redirect:/platos";
        }catch (Exception e){
            model.addAttribute("error",e.toString());
            return "error";
        }
    }


    @GetMapping("/eliminar/plato/{id}")
    public String eliminarPlato(Model model, @PathVariable("id") long id) {
        try {

            this.platosInputPort.eliminarPlato(id);
            return "redirect:/platos";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            System.out.println(e.toString());
            return "error";
        }
    }
}
