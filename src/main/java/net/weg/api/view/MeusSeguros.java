package net.weg.api.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import net.weg.api.model.entity.Seguro;
import net.weg.api.service.CarroService;
import net.weg.api.service.ClienteService;
import net.weg.api.service.SeguradoraService;
import net.weg.api.service.SeguroService;

@Route(value = "/meus-seguros", layout = NavbarApp.class)
public class MeusSeguros extends VerticalLayout {
    public MeusSeguros(CarroService carroService, SeguradoraService seguradoraService,
                       ClienteService clienteService, SeguroService seguroService){
        HorizontalLayout layout = new HorizontalLayout();
        layout.add(new H1("Meus Seguros"));
        Dialog cadastro = new Dialog();
        Grid<Seguro> grid = new Grid<>(Seguro.class);
        cadastro.add(new CadastroSeguro(seguroService, cadastro, clienteService, seguradoraService, carroService));
        layout.add(new Button("Adicionar Seguro", event -> cadastro.open()));
        add(layout);
        grid.setItems(seguroService.buscarTodos());
        grid.removeColumn(grid.getColumnByKey("id"));
        add(grid);
    }

}
