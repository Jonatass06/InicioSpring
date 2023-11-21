package net.weg.api.view;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import net.weg.api.model.dto.SeguroCadastroDTO;
import net.weg.api.model.entity.Carro;
import net.weg.api.model.entity.Cliente;
import net.weg.api.model.entity.Seguradora;
import net.weg.api.service.CarroService;
import net.weg.api.service.SeguradoraService;
import net.weg.api.service.SeguroService;
import net.weg.api.service.UsuarioService;

public class CadastroSeguro extends Dialog {

    private NumberField valor = new NumberField("Valor");
    private TextField descricao = new TextField("Descrição");
    private NumberField valorFranquia = new NumberField("Valor da Franquia");
    private Select<Seguradora> seguradoraSelect = new Select<>();
    private Select<Carro> veiculoSelect = new Select<>();
    private Select<Cliente> usuarioSelect = new Select<>();

    private FormLayout formLayout = new FormLayout();

    private SeguroService seguroService;

    CadastroSeguro(SeguradoraService seguradoraService, CarroService carroService, UsuarioService usuarioService
    ,SeguroService seguroService){
        this.seguroService = seguroService;
        seguradoraSelect.setLabel("Seguradora");
        seguradoraSelect.setItems(seguradoraService.buscarTodos());
        veiculoSelect.setLabel("Veículo");
        veiculoSelect.setItems(carroService.buscarTodos());
//        usuarioSelect.setItemLabelGenerator(item -> toString());
        usuarioSelect.setLabel("Usuário");
        usuarioSelect.setItems(usuarioService.buscarTodos());
        Button salvar = new Button("Salvar", new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> buttonClickEvent) {
                SeguroCadastroDTO seguroCadastroDTO = new SeguroCadastroDTO(valor.getValue(),descricao.getValue(),valorFranquia.getValue(),seguradoraSelect.getValue()
                        ,veiculoSelect.getValue(),usuarioSelect.getValue());
                try {
                    seguroService.cadastrar(seguroCadastroDTO);
                }catch (Exception e){
                    throw new RuntimeException(e);
                }
                  close();
            }
        });
        Button cancelar = new Button("Cancelar", e -> this.close());
        this.getFooter().add(cancelar, salvar);
        formLayout.add(valor,descricao,valorFranquia,veiculoSelect,seguradoraSelect,usuarioSelect);
        add(formLayout);
    }
}
