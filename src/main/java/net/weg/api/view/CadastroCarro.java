package net.weg.api.view;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import lombok.SneakyThrows;
import net.weg.api.model.DTO.CarroCadastroDTO;
import net.weg.api.service.CarroService;


@Route(value = "/carrinho", layout = NavBarApp.class)
public class CadastroCarro extends FormLayout {
    private final CarroService carroService;

    public CadastroCarro(CarroService carroService, Dialog cadastro) {
        this.carroService = carroService;

        TextField placa = new TextField("Placa");
        TextField marca = new TextField("Marca");
        TextField modelo = new TextField("Modelo");
        TextField cor = new TextField("Cor");
        IntegerField ano = new IntegerField("Ano");
        NumberField preco = new NumberField("Preço");

        Button salvar = new Button("Cadastrar carro", new ComponentEventListener<ClickEvent<Button>>() {
            @SneakyThrows
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                CarroCadastroDTO carroCadastroDTO = new CarroCadastroDTO(
                        placa.getValue(),
                        marca.getValue(),
                        cor.getValue(),
                        modelo.getValue(),
                        preco.getValue(),
                        ano.getValue()
                );
                carroService.criar(carroCadastroDTO);
                cadastro.close();
            }
        });
        Button cancelar = new Button("Cancelar", event -> cadastro.close());
        cadastro.getFooter().add(salvar,cancelar);
        add(placa, marca, modelo, cor, ano, preco);
    }
}
