package net.weg.api.view;


import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import net.weg.api.model.dto.CarroCadastroDTO;
import net.weg.api.model.entity.Carro;
import net.weg.api.service.CarroService;

import java.awt.*;


public class CadastroCarro extends FormLayout {

    private final CarroService carroService;

    CadastroCarro(CarroService carroService, Dialog cadastro, Grid<Carro> grid) {
        this.carroService = carroService;
        TextField marca = new TextField("Marca");
        TextField modelo = new TextField("Modelo");
        TextField placa = new TextField("Placa");
        TextField cor = new TextField("Cor");
        IntegerField ano = new IntegerField("Ano");
        NumberField valor = new NumberField("Valor");

        com.vaadin.flow.component.button.Button cancelar =
                new com.vaadin.flow.component.button.Button("Cancelar", event -> cadastro.close());
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
                    grid.setItems(carroService.buscarTodos());
                    cadastro.close();
                });
        cadastro.getFooter().add(cancelar, salvar);
        add(marca, modelo, placa, cor, ano, valor);
    }
}
