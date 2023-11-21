package net.weg.api.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Getter;
import net.weg.api.model.dto.CarroCadastroDTO;
import net.weg.api.service.CarroService;


public class CadastroCarro extends IFormulario{

    private TextField placa = new TextField("placa");
    private TextField marca = new TextField("marca");
    private TextField cor = new TextField("cor");
    private TextField modelo = new TextField("modelo");
    private IntegerField ano = new IntegerField("ano");
    private NumberField preco = new NumberField("preço");

    private FormLayout formLayout = new FormLayout();
    @Getter
    private Button salvar;
    private CarroService carroService;

    CadastroCarro( CarroService carroService) {
        this.carroService = carroService;
        this.salvar = criarBotaoSalvar();
        formLayout.add(placa, marca, cor, modelo, ano, preco);
        this.add(formLayout);
    }

    private Button criarBotaoSalvar(){
       return new BotaoSalvar<>(event -> {
            Notification notification = new Notification();
            notification.setDuration(3000);
            try {
                carroService.cadastrar(new CarroCadastroDTO(placa.getValue(), marca.getValue(), cor.getValue(), modelo.getValue()
                        , preco.getValue(), ano.getValue()));
                notification.setText("Cadasstro realizado com sucesso!");
                notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            }catch (Exception e){
                notification.setText("Erro ao cadastrar!");
                notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                throw new RuntimeException(e);
            } finally {
                notification.open();
            }
        });
    }

//    private Button criarBotaoCanceular(){
//        return  new BotaoCancelar(event -> this.close());
//    }
}
