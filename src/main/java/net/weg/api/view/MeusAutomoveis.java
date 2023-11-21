package net.weg.api.view;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import net.weg.api.model.entity.Carro;
import net.weg.api.service.CarroService;

import java.util.Collection;


@Route(value = "/meus-automoveis", layout = NavBarApp.class)
public class MeusAutomoveis extends VerticalLayout {



    public MeusAutomoveis(CarroService carroService) {


        HorizontalLayout hl = new HorizontalLayout();

        Dialog cadastro = new Dialog();
        cadastro.add(new CadastroCarro(carroService,cadastro));
        H1 h1 = new H1("Meus Automoveis");
        h1.getStyle().set("color","#fff");
        hl.add(h1);


        Button btn = new Button("Novo Carro", e -> cadastro.open());
        btn.getStyle().set("background-color","#fff");
        btn.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        hl.add(btn);

        getStyle().set("background-color","#092C4C");
        hl.getStyle().set("display","flex");
        hl.getStyle().set("align-items","center");

        add(hl);
        Grid<Carro> grid = new Grid<>(Carro.class);
        grid.setItems(carroService.buscarTodos());
        add(grid);

    }
}
