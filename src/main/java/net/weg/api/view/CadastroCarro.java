package net.weg.api.view;


import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import net.weg.api.model.dto.CarroCadastroDTO;
import net.weg.api.service.CarroService;


public class CadastroCarro extends Dialog {

    private final CarroService carroService;
    private final FormLayout fl = new FormLayout();
    private final TextField marca = new TextField("Marca");
    private final TextField modelo = new TextField("Modelo");
    private final TextField placa = new TextField("Placa");
    private final TextField cor = new TextField("Cor");
    private final IntegerField ano = new IntegerField("Ano");
    private final NumberField valor = new NumberField("Valor");
    private final BotaoCancelar cancelar;

    CadastroCarro(CarroService carroService) {
        this.cancelar = new BotaoCancelar(this);
        this.carroService = carroService;
        com.vaadin.flow.component.button.Button salvar =
                new com.vaadin.flow.component.button.Button("Salvar", e -> {
                    CarroCadastroDTO carro = new CarroCadastroDTO(
                            marca.getValue(),
                            cor.getValue(),
                            placa.getValue(),
                            modelo.getValue(),
                            valor.getValue(),
                            ano.getValue()
                    );
                    try{
                        carroService.salvar(carro);
                    }catch (Exception exception){
                        exception.printStackTrace();
                    }
                    this.close();
                });
        this.fl.add(marca, modelo, placa, cor, ano, valor);
        add(this.fl);
        this.getFooter().add(this.cancelar, salvar);
    }
}
