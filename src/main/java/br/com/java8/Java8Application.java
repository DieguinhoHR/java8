package br.com.java8;

import br.com.java8.lambda.Usuario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Java8Application {
    @PostConstruct
    public void listaUsuarios() {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilher Silveira", 190);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        // Consumer<Usuario> mostrador = (Usuario u) -> {System.out.println(u.getNome());};
        // Consumer<Usuario> mostrador = u -> {System.out.println(u.getNome());};
        // Consumer<Usuario> mostrador = u -> System.out.println(u.getNome());
        usuarios.forEach(u -> System.out.println(u.getNome()));
    }

    public static void main(String[] args) {
        SpringApplication.run(Java8Application.class, args);
    }

}

