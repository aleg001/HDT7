/*******************************************************
* Universidad del Valle de Guatemala
* Algoritmos y Estructuras de Datos
* Profesor: Moises Gonzales
* BinaryTree.java
* Autor: Alejandro Gomez
* Autor: Geek for Geeks
* Fecha de creacion: 09-04-21
* Ultima edicion: 13-04-21
********************************************************/

import java.util.ArrayList;

public class BinaryTree {
    
    /* Clase adaptada de Geeks for Geeks
       con modificaciones por Alejandro Gomez*/

    class Node
    {
        // Atributos
        ArrayList<String> key;
        Node left, right;

        
        
    /**
     * Node
     * @param ArrayList<String>
     * @author Alejandro Gomez y GeekForGeeks
     * @return n/a
     **/
        public Node(ArrayList<String> item)
        { key = item; left = right = null; }
    }
 
    // Root of BST
    Node root;
 
    // Constructor
    BinaryTree()
    { root = null; }
 
    
    /**
     * Insertar 
     * @param ArrayList<String>
     * @author Alejandro Gomez y GeekForGeeks
     * @return n/a
     */
    // This method mainly calls insertRec()
    void insertar(ArrayList<String> key)
    { root = AgregarR( root, key ); }
 
    
    /** 
     * AgregarR
     * @param Nodo
     * @param ArrayList<String>
     * @return Nodo
     * @author Alejandro Gomez y GeekForGeeks
     */
    /*Se utiliza para agregar una nueva llave en el BST*/
    Node AgregarR(Node root, ArrayList<String> key)
    {
 
        if (root == null) // En caso lo encuentre vacio, crea un nuevo nodo
        { root = new Node(key) ;return root; }
 
        if (key.get(0).compareTo(root.key.get(0))<0) // En caso si exista, realiza procesos
            root.left = AgregarR(root.left, key);
        else if (key.get(0).compareTo(root.key.get(0))>0)
            root.right = AgregarR(root.right, key);
 
        /* Devuelve el pointer del nodo */
        return root;
    }
 
    // Metodo para devolverlo ordenado.
    void Ordenado()
    { MostrarBSTOrdenado(root); }
 
    
    /** 
     * MostrarBSTOrdenado
     * Metodo para ordenar el BST
     * @param root
     * @author Alejandro Gomez y GeekForGeeks
     */

    void MostrarBSTOrdenado( Node root ) {
        if ( root != null ) 
        {
            MostrarBSTOrdenado(root.left);
            System.out.println(root.key);
            MostrarBSTOrdenado(root.right);
        }
    }


}