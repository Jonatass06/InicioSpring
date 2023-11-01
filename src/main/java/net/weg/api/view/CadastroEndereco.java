package net.weg.api.view;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import net.weg.api.model.dto.EnderecoCadastroDTO;
import net.weg.api.model.entity.Endereco;


public class CadastroEndereco extends FormLayout {

    private TextField rua = new TextField("Rua");
    private TextField bairro = new TextField("Bairro");
    private IntegerField numero = new IntegerField("Numero");
    private Button salvar;
    private Button cancelar;

    CadastroEndereco(Grid<EnderecoCadastroDTO> enderecos, Dialog cadastroEndereco) {
        add(
                new Text("Cadastro de Endereco"),
                rua, bairro, numero
        );
        cadastroEndereco.getFooter().add(
                cancelar = new Button("Cancelar", event -> cadastroEndereco.close()),
                salvar = new Button("Salvar", event -> {
                    enderecos.getListDataView().addItem(new EnderecoCadastroDTO(
                            rua.getValue(),
                            bairro.getValue(),
                            numero.getValue()
                    ));
                    cadastroEndereco.close();
                })
        );

    }

}