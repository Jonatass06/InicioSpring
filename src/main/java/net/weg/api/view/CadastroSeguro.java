package net.weg.api.view;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import lombok.SneakyThrows;
import net.weg.api.model.DTO.CarroCadastroDTO;
import net.weg.api.model.DTO.SeguroCadastroDTO;
import net.weg.api.model.entity.Carro;
import net.weg.api.model.entity.Cliente;
import net.weg.api.model.entity.Seguradora;
import net.weg.api.model.entity.Usuario;
import net.weg.api.service.CarroService;
import net.weg.api.service.ClienteService;
import net.weg.api.service.SeguradoraService;
import net.weg.api.service.SeguroService;

public class CadastroSeguro extends FormLayout {

    private SeguroService seguroService;

    CadastroSeguro(SeguradoraService seguradoraService, CarroService carroService,
                   ClienteService usuarioService, SeguroService seguroService, Dialog cadastro) {
        this.seguroService = seguroService;

        NumberField valor = new NumberField("Valor");
        TextField descricao = new TextField("Descrição");
        NumberField valorFranquia = new NumberField("Valor da Franquia");
        Select<Seguradora> seguradora = new Select<>();
//        seguradora.setItemLabelGenerator(Seguradora::getNome);
        seguradora.setLabel("Seguradora");
        seguradora.setItems(seguradoraService.buscarTodos());
        Select<Carro> veiculo  = new Select<>();
        veiculo.setLabel("Carro");
        veiculo.setItems(carroService.buscarTodos());
        Select<Cliente> usuario  = new Select<>();
//        usuario.setItemLabelGenerator(Cliente::toString);
        usuario.setLabel("Usuario");
        usuario.setItems(usuarioService.buscarTodos());

        Button salvar = new Button("Cadastrar Seguro", new ComponentEventListener<ClickEvent<Button>>() {
            @SneakyThrows
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                SeguroCadastroDTO seguroCadastroDTO = new SeguroCadastroDTO(
                        valor.getValue(),
                        descricao.getValue(),
                        valorFranquia.getValue(),
                        seguradora.getValue(),
                        veiculo.getValue(),
                        usuario.getValue()
                );
                seguroService.salvar(seguroCadastroDTO);
                cadastro.close();
            }
        });
        Button cancelar = new Button("Cancelar", event -> cadastro.close());
        cadastro.getFooter().add(salvar,cancelar);

        add(valor,descricao,valorFranquia,veiculo,seguradora,usuario);
    }
}
