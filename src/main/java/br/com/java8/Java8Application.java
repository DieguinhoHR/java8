package br.com.java8;

import br.com.java8.lambda.Usuario;
import br.com.java8.lambda.Validator;
import lombok.var;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

@SpringBootApplication
public class Java8Application {
    @PostConstruct
    public void listaUsuarios() {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);


        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        Consumer<Usuario> mostraMensagem = u ->
                System.out.println("antes de imprimir os nomes");

        Consumer<Usuario> imprimeNome = u ->
                System.out.println(u.getNome());

        usuarios.forEach(mostraMensagem.andThen(imprimeNome));

        Predicate<Usuario> predicado = u -> u.getPontos() > 160;

        List<Usuario> usuarios2 = new ArrayList<Usuario>();

        usuarios2.add(user1);
        usuarios2.add(user2);
        usuarios2.add(user3);

        usuarios2.removeIf(predicado);
        usuarios2.forEach(u -> System.out.println(u.getNome()));
    }

    @PostConstruct
    public void ordena() {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);

        Usuario rodrigo = new Usuario("Paulo Turini", 50);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        Collections.sort(usuarios, (u1, u2) -> u1.getNome().compareTo(u2.getNome()));

        Consumer<Usuario> consumer = Usuario::tornarModerador;
        consumer.accept(rodrigo);
    }

    @PostConstruct
    public void interfaceFuncional() {
        // interface funcional
        final String regex = "[0-9]{5}-[0-9]{3}";
        Validator<String> validatorCEP = valor -> valor.matches(regex);
        validatorCEP.validar("14101-300");
    }

    public static void main(String[] args) {
        SpringApplication.run(Java8Application.class, args);
    }

}

