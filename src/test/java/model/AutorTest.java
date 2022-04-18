package model;

import br.edu.femass.biblioteca.model.Autor;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

public class AutorTest {

    //Testa inserção de novo Autor com campo vazio usando assertThrows
    @Test
    void testConstrutorCampoVazio(){
        assertThrows(InputMismatchException.class,
        () -> {
            Autor at = new Autor(""," ");
        });
    }

    //Testa método toString utilizando assertEquals
    @Test
    void testToString(){
        Autor au = new Autor("Fulano", "de Tal");
        String esperado = "Fulano de Tal";
        assertEquals(esperado, au.toString());
    }
}
