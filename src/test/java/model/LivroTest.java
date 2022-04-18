package model;

import br.edu.femass.biblioteca.model.Copia;
import br.edu.femass.biblioteca.model.GeneroLivro;
import br.edu.femass.biblioteca.model.Livro;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LivroTest {

    //Testa inserção de novo Livro com campos vazios usando assertThrows
    @Test
    void testConstrutorCampoVazio(){
        assertThrows(InputMismatchException.class,
                () -> {
                    Livro lv = new Livro(""," ", GeneroLivro.Academico);
                });
    }

    /*Testa adição de duas cópias de um Livro utilizando assertEquals. Considera o estado fixo = true
    e disponível = false para a primeira cópia, e fixo = false com disponível = true para cópias
    adicionadas posteriormente*/
    @Test
    void testAddCopia(){
        Livro e = new Livro("Livro_Exemplo1", "1º Edição, 2022", GeneroLivro.Academico);
        String esperado = "Copia{fixo=true, disponivel=false}";
        assertEquals(esperado, e.getCopias().get(0).toString());
        e.addCopia(new Copia());
        String esperado2 = "Copia{fixo=false, disponivel=true}";
        assertEquals(esperado2, e.getCopias().get(1).toString());
    }

    /*Testa checagem de primeira cópia disponivel e sua função de torna-la indisponível para reserva
    de empréstimo utilizando assertEquals*/
    @Test
    void testGetPrimeiraCopiaDisponivel(){
        Livro e = new Livro("Livro_Exemplo2", "1º Edição, 2022", GeneroLivro.Academico);

        //A primeira cópia não é disponível por ser fixa para uso na biblioteca
        String esperado = "false";
        assertEquals(esperado, e.getPrimeiraCopiaDisponivel().toString());
        e.addCopia(new Copia());
        //A adição de uma segunda cópia a torna disponível para reserva
        String esperado2 = "true";
        assertEquals(esperado2, e.getPrimeiraCopiaDisponivel().toString());
        //A utilização do método getPrimeiraCopiaDisponivel torna a segunda cópia indisponível
        String esperado3 = "false";
        assertEquals(esperado3, e.getPrimeiraCopiaDisponivel().toString());
    }

    @Test
    void testToString(){
        Livro lv = new Livro("Livro_Exemplo3", "1º Edição, 2022", GeneroLivro.Academico);
        String esperado = "Nome='Livro_Exemplo3', edicao='1º Edição, 2022', genero=Academico, autores=[], copias=[Copia{fixo=true, disponivel=false}]}";
        assertEquals(esperado, lv.toString());
    }
}
