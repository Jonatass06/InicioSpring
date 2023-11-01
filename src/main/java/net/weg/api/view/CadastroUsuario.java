package net.weg.api.view;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import net.weg.api.model.dto.EnderecoCadastroDTO;
import net.weg.api.model.dto.UsuarioCadastroDTO;
import net.weg.api.model.entity.Endereco;
import net.weg.api.service.ClienteService;
import org.springframework.beans.BeanUtils;

import java.util.HashSet;
import java.util.Set;


@Route("/cadastro-usuario")
public class CadastroUsuario extends FormLayout {

    private final ClienteService clienteService;
    private TextField nome = new TextField("Usuario");
    private PasswordField senha = new PasswordField("Senha");
    private PasswordField confirmarSenha = new PasswordField("Confirme a Senha");
    private IntegerField idade = new IntegerField("Idasde");
    private Grid<EnderecoCadastroDTO> enderecos = new Grid<>(EnderecoCadastroDTO.class);
    private Dialog enderecoCadastro = new Dialog();
    private Button novoEndereco;
    private Button cadastrar;
    private Button cancelar;

    CadastroUsuario(ClienteService clienteService) {
        this.clienteService = clienteService;
        add(nome, senha, confirmarSenha, idade, enderecos, enderecoCadastro,
                novoEndereco = new Button("Novo Endereco", event -> enderecoCadastro.open()),
                cadastrar = new Button("Cadastrar", event -> {
                    Notification notification = new Notification();
                    notification.setDuration(3000);
                    Set<Endereco> listaDeEnderecos = new HashSet<>();
                    try {
                        if (!senha.getValue().equals(confirmarSenha.getValue())) {
                            throw new Exception("Senhas não conferem");
                        }
                        enderecos.getListDataView().getItems().forEach(
                                ecdto -> {
                                    Endereco endereco = new Endereco();
                                    BeanUtils.copyProperties(ecdto, endereco);
                                    listaDeEnderecos.add(endereco);
                                }
                        );
                        clienteService.salvar(new UsuarioCadastroDTO(
                                nome.getValue(),
                                senha.getValue(),
                                idade.getValue(),
                                listaDeEnderecos)
                        );
                        notification.setText("Usuario cadastrado com sucesso");
                        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
                    } catch (Exception e) {
                        notification.setText("Erro ao cadastrar usuario");
                        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                        e.printStackTrace();
                    } finally {
                        notification.open();
                    }
                }),
                this.cancelar = new Button("Voltar", event -> getUI().get().navigate("inicio"))

        );
        this.enderecoCadastro.add(new CadastroEndereco(enderecos, enderecoCadastro));
    }

}
