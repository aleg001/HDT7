/*******************************************************
* Universidad del Valle de Guatemala
* Algoritmos y Estructuras de Datos
* Profesor: Moises Gonzales
* Main.java
* Autor: Alejandro Gomez
* Fecha de creacion: 09-04-21
* Ultima edicion: 13-04-21
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
        ArrayList<String> TextoEnArchivo = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        String StringNameFile = "";
        ArrayList<ArrayList<String>> DiccionarioAUtilizar =  new ArrayList<ArrayList<String>>();
        String StringNameFile1 = "";
        boolean OpcionesMenu = false;

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
        for(ArrayList<String> BusquedaPalabras: DiccionarioAUtilizar)
        { BT.insertar(BusquedaPalabras); } // Inserta las palabras al binarytree


        // Se muestra el diccionario de forma ordenada
        v.OrdenarDic();
        BT.Ordenado();

        // Se define el menu para la realizacion de procesos en el programa.
        while(OpcionesMenu == false)
        {
            int OpcionesDelMenu = v.MenuOp();
            
            if(OpcionesDelMenu == 1){
                // Se muestra mensaje de bienvenida
                v.Iniciando();
                int SeleccionLenguaje = v.Options();
                
                // Se definen instrucciones para utilizar diccionario al cual se desea traducir
                switch(SeleccionLenguaje)
                {    
                    // Caso 1 corresponde a ingles
                    case 1:

                        for(int i=0;i<DiccionarioAUtilizar.size();i++)
                        {    
                            for(int j=0;j<TextoEnArchivo.size();j++)
                                {
                                if(DiccionarioAUtilizar.get(i).contains(TextoEnArchivo.get(j)))
                                {TextoEnArchivo.set(j, DiccionarioAUtilizar.get(i).get(0));}
                                }
                            }
                        break;

                     // Caso 2 corresponde a espanol
                    case 2:
                        for(int i=0;i<DiccionarioAUtilizar.size();i++)
                        {
                            for(int j=0;j<TextoEnArchivo.size();j++)
                            {
                                if(DiccionarioAUtilizar.get(i).contains(TextoEnArchivo.get(j)))
                                {
                                    TextoEnArchivo.set(j, DiccionarioAUtilizar.get(i).get(1));}
                            }
                        }
                        break;

                     // Caso 3 corresponde a frances
                    case 3:
                    for(int i=0;i<DiccionarioAUtilizar.size();i++)
                    {
                        for(int j=0;j<TextoEnArchivo.size();j++)
                        {
                            if(DiccionarioAUtilizar.get(i).contains(TextoEnArchivo.get(j)))
                            {
                                TextoEnArchivo.set(j, DiccionarioAUtilizar.get(i).get(2));}
                        }
                    }
                        break;


                    default:
                        v.Error();
                        break;
                }

                // Se muestra la traduccion correspondiente.
                v.Lineas();
                String p = "";
                TextoEnArchivo.set(TextoEnArchivo.size()-1,(TextoEnArchivo.get(TextoEnArchivo.size()-1)));

                // Ciclo for para las palabras traducidas.
                for(int i=0;i<TextoEnArchivo.size();i++)
                {
                    // Se realiza una iteracion dentro del ciclo for para cada una de las palabras a traducir.
                    p += (TextoEnArchivo.get(i) + " ");
                }
                // Se imprime la variable definida con la traduccion
                v.Impresion(p);



            }
            // En caso se decida salir, se muestra mensaje de salida.
            else{OpcionesMenu = true; v.Despedida();}



        }



    }
}
