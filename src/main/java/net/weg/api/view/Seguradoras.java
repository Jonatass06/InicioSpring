package net.weg.api.view;

import com.vaadin.flow.router.Route;
import net.weg.api.model.entity.Seguradora;
import net.weg.api.service.SeguradoraService;

@Route(value = "/seguradoras", layout = NavBarApp.class)
public class Seguradoras extends PaginaPadrao<Seguradora> {

    private SeguradoraService seguradoraService;

    Seguradoras(SeguradoraService seguradoraService){
        super("Seguradoras", seguradoraService.buscarTodos(), Seguradora.class);
    }
}
