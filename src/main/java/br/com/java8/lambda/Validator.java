package br.com.java8.lambda;

@FunctionalInterface // Serve para que ningué torne ela não funcional
public interface Validator<T> {
    boolean validar(T type);
}
