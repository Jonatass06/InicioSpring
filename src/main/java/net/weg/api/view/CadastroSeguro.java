package net.weg.api.view;


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
import net.weg.api.model.entity.Seguro;
import net.weg.api.service.CarroService;
import net.weg.api.service.ClienteService;
import net.weg.api.service.SeguradoraService;
import net.weg.api.service.SeguroService;


public class CadastroSeguro extends FormLayout {

    private final SeguroService seguroService;

    CadastroSeguro(SeguroService seguroService, Dialog cadastro, ClienteService clienteService,
                   SeguradoraService seguradoraService, CarroService carroService) {
        this.seguroService = seguroService;

        NumberField valor = new NumberField("Valor");
        TextField descricao = new TextField("Descrição");
        NumberField valorFranquia = new NumberField("Valor da Franquia");
//      Selects
        Select<Seguradora> seguradora = new Select<>();
        seguradora.setLabel("Seguradora");
        seguradora.setItems(seguradoraService.buscarTodos());
        seguradora.setItemLabelGenerator(Seguradora::getNome);

        Select<Carro> veiculo = new Select<>();
        veiculo.setLabel("Carro");
        veiculo.setItems(carroService.buscarTodos());
        veiculo.setItemLabelGenerator(Carro::getPlaca);

        Select<Cliente> cliente = new Select<>();
        cliente.setLabel("Cliente");
        cliente.setItems(clienteService.buscarTodos());
        cliente.setItemLabelGenerator(Cliente::getNome);

        Button cancelar =
                new Button("Cancelar", event -> cadastro.close());
        Button salvar =
                new Button("Salvar", e -> {
                    SeguroCadastroDTO seguro = new SeguroCadastroDTO(
                            valor.getValue(),
                            descricao.getValue(),
                            valorFranquia.getValue(),
                            seguradora.getValue(),
                            veiculo.getValue(),
                            cliente.getValue()
                    );
                    try{
                        seguroService.salvar(seguro);
                    }catch (Exception exception){
                        exception.printStackTrace();
                    }
                    cadastro.close();
                });
        cadastro.getFooter().add(cancelar, salvar);
        add(valor, descricao, valorFranquia, seguradora, veiculo, cliente);
    }
}
