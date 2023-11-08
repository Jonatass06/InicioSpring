package net.weg.api.view;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.Route;
import net.weg.api.model.entity.Carro;
import net.weg.api.service.CarroService;

@Route(value = "/meus-automoveis", layout = NavbarApp.class)
public class MeusAutomoveis extends PaginaPadrao<Carro> {

    public MeusAutomoveis(CarroService carroService) {
        super("Meus Automoveis", carroService.buscarTodos(), Carro.class,
                new Button("Adicionar Automovel", event -> new CadastroCarro(carroService).open()));
    }

}
