package net.weg.api.view;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import net.weg.api.model.dto.SeguroCadastroDTO;
import net.weg.api.model.entity.Carro;
import net.weg.api.model.entity.Cliente;
import net.weg.api.model.entity.Seguradora;
import net.weg.api.model.entity.Seguro;
import net.weg.api.service.CarroService;
import net.weg.api.service.ClienteService;
import net.weg.api.service.SeguradoraService;
import net.weg.api.service.SeguroService;

import java.util.ArrayList;
import java.util.List;


public class CadastroSeguro extends Dialog {

    private final SeguroService seguroService;
    private final NumberField valor = new NumberField("Valor");
    private final TextField descricao = new TextField("Descrição");
    private final NumberField valorFranquia = new NumberField("Valor da Franquia");
    //      Selects
    private final Select<Seguradora> seguradora = new Select<>();
    private final Select<Carro> veiculo = new Select<>();
    private final Select<Cliente> cliente = new Select<>();
    private final FormLayout fl = new FormLayout();
    private final BotaoCancelar cancelar;
    private final Button salvar;


    CadastroSeguro(SeguroService seguroService, ClienteService clienteService,
                   SeguradoraService seguradoraService, CarroService carroService) {
        this.seguroService = seguroService;
        //      Selects
        this.cliente.setLabel("Cliente");
        this.cliente.setItems(clienteService.buscarTodos());
        this.veiculo.setLabel("Carro");
        this.veiculo.setItems(carroService.buscarTodos());
        this.seguradora.setLabel("Seguradora");
        this.seguradora.setItems(seguradoraService.buscarTodos());
        this.cancelar = new BotaoCancelar(this);
        this.salvar =
                new Button("Salvar", e -> {
                    Notification notification = new Notification();
                    notification.setDuration(3000);

                    SeguroCadastroDTO seguro = new SeguroCadastroDTO(
                            valor.getValue(),
                            descricao.getValue(),
                            valorFranquia.getValue(),
                            seguradora.getValue(),
                            veiculo.getValue(),
                            cliente.getValue()
                    );
                    try {
                        this.seguroService.salvar(seguro);
                        notification.setText("Usuario cadastrado com sucesso");
                        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
                    } catch (Exception exception) {
                        notification.setText("Erro ao cadastrar usuario");
                        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                        exception.printStackTrace();
                    } finally {
                        notification.open();
                    }
                    this.close();
                });
        this.getFooter().add(cancelar, salvar);
        this.fl.add(this.valor, this.descricao, this.valorFranquia, this.seguradora, this.veiculo, this.cliente);
        add(this.fl);
    }
}
