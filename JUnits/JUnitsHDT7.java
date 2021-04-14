import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

class JUnitsHDT7 {

	private BinaryTree BT;
	private BinaryTree PruebasAIdentificar2;
	private BinaryTree PruebasAIdentificar3;
	private BinaryTree PruebasAIdentificar;
	// Se definen arraylists
	ArrayList<String> originalTexto = new ArrayList<String>();
	ArrayList<String> traduccionespanish = new ArrayList<String>();
	
   
    // Se agregan los elementos a traducir en los arraylists
    traduccionespanish.add("perro");
    traduccionespanish.add("conejo");
    traduccionespanish.add("tarea");
    originalTexto.add("dog");
    originalTexto.add("rabbit");
    originalTexto.add("homework");
	
	public void BeforeProcess() {
		BT.insertar(originalTexto);
		PruebasAIdentificar.insertar(traduccionespanish);
		
	}
	
	@Test
	void testInsercion() {
		assertEquals(originalTexto,BT);
	}


}
