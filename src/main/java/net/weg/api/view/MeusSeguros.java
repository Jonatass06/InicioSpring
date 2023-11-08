package net.weg.api.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.Route;
import net.weg.api.model.entity.Seguro;
import net.weg.api.service.CarroService;
import net.weg.api.service.ClienteService;
import net.weg.api.service.SeguradoraService;
import net.weg.api.service.SeguroService;

@Route(value = "/meus-seguros", layout = NavbarApp.class)
public class MeusSeguros extends PaginaPadrao {
    public MeusSeguros(CarroService carroService, SeguradoraService seguradoraService,
                       ClienteService clienteService, SeguroService seguroService){
        super("Meus Seguros", seguroService.buscarTodos(), Seguro.class,
                new Button("Adicionar Seguro", event -> new CadastroSeguro(seguroService, clienteService, seguradoraService, carroService).open()));
    }

}
