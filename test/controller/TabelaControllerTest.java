/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.TabelaModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel Leal
 */
public class TabelaControllerTest {
    
    public TabelaControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testInserirJogo() {
        TabelaModel t = new TabelaModel();
        TabelaController teste = new TabelaController();
        t.setPlacar(15);
        assertTrue(teste.inserirJogo(t));
    }


    @Test
    public void testExcluir() {
        TabelaModel t = new TabelaModel();
        TabelaController teste = new TabelaController();
        t = teste.selecionarUltimo();
        assertTrue(teste.excluir(t));    
    }

      
    
}
