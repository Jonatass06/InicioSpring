package net.weg.api.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.BackEndDataProvider;
import com.vaadin.flow.router.Route;
import net.weg.api.model.DTO.EnderecoCadastroDTO;
import net.weg.api.model.DTO.UsuarioCadastroDTO;
import net.weg.api.model.entity.Endereco;
import net.weg.api.model.entity.Usuario;
import net.weg.api.service.ClienteService;
import org.springframework.beans.BeanUtils;

import java.util.HashSet;
import java.util.Set;

@Route(value = "/endereco", layout = NavBarApp.class)
public class CadastroUsuario extends FormLayout {

    private ClienteService usuarioService;

    private TextField usuario = new TextField("Usuário");
    private TextField nome = new TextField("Nome");
    private TextField sobrenome = new TextField("Sobrenome");
    private PasswordField senha = new PasswordField("Senha");
    private PasswordField confirmacaoSenha = new PasswordField("Confirmar senha");
    private IntegerField idade = new IntegerField("Idade");
    private Grid<EnderecoCadastroDTO> gridEnderecos = new Grid<>(EnderecoCadastroDTO.class);
    private Dialog cadastroEndereco = new Dialog();
    private Button novoEndereco;
    private Button salvar, cancelar;


    public CadastroUsuario(ClienteService usuarioService) {
        this.usuarioService = usuarioService;

        cadastroEndereco.add(new CadastroEndereco(gridEnderecos, cadastroEndereco));
        novoEndereco = new Button("Novo Endereço", event -> cadastroEndereco.open());


        salvar = new Button("Salvar",
                event -> {
                    Set<Endereco> enderecos = new HashSet<>();
                    Notification notification = new Notification();
                    notification.setDuration(3000);
                    try {

                        gridEnderecos.getListDataView().getItems().forEach(
                                ecdto -> {
                                    Endereco endereco = new Endereco();
                                    BeanUtils.copyProperties(ecdto, endereco);
                                    enderecos.add(endereco);

                                });

                        if (senha.getValue().equals(confirmacaoSenha.getValue())) {
                            usuarioService.salvar(new UsuarioCadastroDTO(
                                    usuario.getValue(),
                                    nome.getValue(),
                                    sobrenome.getValue(),
                                    senha.getValue(),
                                    idade.getValue(),
                                    enderecos
                            ));
                        }
                        notification.setText("Usuário cadastrado com sucesso!");
                        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
                    } catch (Exception e) {
                        notification.setText("Erro no cadastro do usuário!");
                        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                    } finally {
                        notification.open();
                    }

                });
        cancelar = new Button("Cancelar", event -> new UI().navigate("/"));

//        Grid<Usuario> usuarioGrid = new Grid<>(Usuario.class);
//        gridEnderecos.setItems((BackEndDataProvider<EnderecoCadastroDTO, Void>) usuarioService.buscarTodos());

        add(usuario, sobrenome, nome, senha, confirmacaoSenha, idade, novoEndereco, gridEnderecos, salvar, cancelar);


    }
}
