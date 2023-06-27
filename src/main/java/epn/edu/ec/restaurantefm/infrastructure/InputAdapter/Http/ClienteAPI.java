package epn.edu.ec.restaurantefm.infrastructure.InputAdapter.Http;

import epn.edu.ec.restaurantefm.Domain.Cliente;
import epn.edu.ec.restaurantefm.infrastructure.InputPort.ClientesInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ClienteAPI {

    @Autowired
    ClientesInputPort clientesInputPort;
    @GetMapping("/clientes")
    public String getAllClientes(Model model){
        try {
            model.addAttribute("clientes", clientesInputPort.obtenerClientes());
            return "cliente/index";
        } catch (Exception e){
            model.addAttribute("error", e.toString());
            return "error";
        }
    }

    @GetMapping("/detalleCliente/{id}")
    public String detalleCliente(Model model, @PathVariable("id") long id) {
        try {
            Cliente cliente = clientesInputPort.buscarClientePorId(id);
            model.addAttribute("cliente", cliente);
            return "cliente/detalle";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/formulario/cliente/{id}")
    public String formularioCliente(Model model, @PathVariable("id") long id) {
        try {
            if (id == 0) {
                Cliente cliente = new Cliente();
                cliente.setId(0L);
                model.addAttribute("cliente", cliente);
                System.out.println("formulario nuevo cliente");
            } else {
                model.addAttribute("cliente", clientesInputPort.buscarClientePorId(id));
                System.out.println("formulario actualizar cliente");
            }
            return "cliente/formulario";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/formulario/cliente/{id}")
    public String guardarCliente(
            @Valid @ModelAttribute("cliente") Cliente cliente,
            BindingResult result,
            Model model,
            @PathVariable("id") long id
    ) throws ParseException {
        try {
            if (result.hasErrors()) {
                model.addAttribute((result.hasErrors()));
                return "error";
            }


            if (cliente.getId() == 0) {
                clientesInputPort.agregarCliente(cliente);
            } else {

                clientesInputPort.actualizarCliente(cliente);
            }
            return "redirect:/clientes";
        } catch (Exception e) {
            model.addAttribute("error", e.toString());
            return "error";
        }
    }

    @GetMapping("/eliminar/cliente/{id}")
    public String eliminarCliente(Model model, @PathVariable("id") long id) {
        try {
            clientesInputPort.eliminarCliente(id);
            return "redirect:/clientes";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            System.out.println(e.toString());
            return "error";
        }
    }
}
