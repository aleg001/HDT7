/*******************************************************
* Universidad del Valle de Guatemala
* Algoritmos y Estructuras de Datos
* Profesor: Moises Gonzales
* Main.java
* Autor: Alejandro Gomez
* Fecha de creacion: 09-04-21
* Ultima edicion: 09-04-21
********************************************************/

// Se declaran imports
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Controlador {
    
    /**
     * Controlador para el programa
     * @param n/a
     * @author Alejandro Gomez
     * @return n/a
     **/
    Controlador(){
        // Se declaran instancias y variables
        Vista v = new Vista();
        BinaryTree BT = new BinaryTree();
        int OpcionesParaMenu = 0;
        ArrayList<String> TextoEnArchivo = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        String StringNameFile = "";
        ArrayList<ArrayList<String>> DiccionarioAUtilizar =  new ArrayList<ArrayList<String>>();
        String StringNameFile1 = "";

        v.Welcome();
        // Lectura del Diccionario por medio del import file

        try {
            v.FileName();
            StringNameFile = s.nextLine();
            File InformacionDelArchivo = new File(StringNameFile);
            Scanner readerFromFile = new Scanner(InformacionDelArchivo);
            
            while (readerFromFile.hasNextLine()) {
                // Se agregan las lineas del archivo a un string, el cual es separado posteriormente y agregado a arraylist
                String LineasEnArchivo = readerFromFile.nextLine();
                String[] SeparacionPorComa = LineasEnArchivo.split(",");
                ArrayList<String> ArrayConInfoSeparada = new ArrayList<>();

                // Se declara ciclo for para agregar las palabras separadas por coma.
                for(int i=0;i<SeparacionPorComa.length;i++)
                { ArrayConInfoSeparada.add(SeparacionPorComa[i]); }
                DiccionarioAUtilizar.add(ArrayConInfoSeparada); }  
        } catch( Exception e ){ v.Error(); }

      // Lectura del TextoATraducir
      try {
        v.FileName1();
        StringNameFile1 = s.nextLine();
        File InformacionDelArchivo = new File(StringNameFile1);
        Scanner readerFromFile = new Scanner(InformacionDelArchivo);
        
        while(readerFromFile.hasNextLine()){
            // Se realiza proceso para el texto que se quiere traducir
            String LineasEnArchivo = readerFromFile.nextLine();
            v.Palabras(LineasEnArchivo);
            String[] SeparacionPorEspacio = LineasEnArchivo.split(" ");


            // Se declara ciclo for para agregar las palabras separadas por coma.
            for( int i=0;i<SeparacionPorEspacio.length;i++ )
            { TextoEnArchivo.add(SeparacionPorEspacio[i]); }
                    
        }  // Agregar a array las cosas jejeje  
    }catch(Exception e){v.Error();}

    // El BinaryTree se encarga de recorrer e imprimir el diccionario.








    }
}
