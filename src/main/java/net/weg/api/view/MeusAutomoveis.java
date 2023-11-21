package net.weg.api.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import net.weg.api.model.entity.Carro;
import net.weg.api.service.CarroService;



@Route(value = "/meus-autos", layout = NavBarApp.class)
public class MeusAutomoveis extends PaginaPadrao<Carro> {

    public MeusAutomoveis(CarroService carroService) {
        super("Meus automóveis",
                carroService.buscarTodos(),
                Carro.class,
                new Button("Novo Carro", e -> new Modal(
                        new CadastroCarro(carroService)
//                        ,new BotaoSalvar(),
//                        new BotaoCancelar()
                ).open()));



    }
}
