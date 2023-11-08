package net.weg.api.view;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import net.weg.api.model.entity.Seguradora;
import net.weg.api.service.SeguradoraService;

@Route(value = "/seguradoras", layout = NavbarApp.class)
public class Seguradoras extends PaginaPadrao<Seguradora> {
    private SeguradoraService seguradoraService;
    public Seguradoras(SeguradoraService seguradoraService){
        super("Seguradoras", seguradoraService.buscarTodos(), Seguradora.class);
        this.seguradoraService = seguradoraService;

    }

}
