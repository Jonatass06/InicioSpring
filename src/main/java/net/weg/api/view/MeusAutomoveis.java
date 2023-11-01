package net.weg.api.view;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import net.weg.api.model.entity.Carro;
import net.weg.api.service.CarroService;

@Route(value = "/meus-automoveis", layout = NavbarApp.class)
public class MeusAutomoveis extends VerticalLayout {

    public MeusAutomoveis(CarroService carroService) {
        HorizontalLayout layout = new HorizontalLayout();
        layout.add(new H1("Meus Automoveis"));
        Dialog cadastro = new Dialog();
        Grid<Carro> grid = new Grid<>(Carro.class);
        cadastro.add(new CadastroCarro(carroService, cadastro, grid));
        layout.add(new Button("Adicionar Automovel", event -> cadastro.open()));
        add(layout);
        grid.setItems(carroService.buscarTodos());
        grid.removeColumnByKey("id");
        add(grid);
    }

    private void cadastrar(Dialog cadastro) {
    }

}
