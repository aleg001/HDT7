/*******************************************************
* Universidad del Valle de Guatemala
* Algoritmos y Estructuras de Datos
* Profesor: Moises Gonzales
* BinaryTree.java
* Autor: Alejandro Gomez
* Autor: Geek for Geeks
* Fecha de creacion: 09-04-21
* Ultima edicion: 09-04-21
********************************************************/

import java.util.ArrayList;

public class BinaryTree {
    /* Clase adaptada de Geeks for Geeks
       con modificaciones por Alejandro Gomez*/

    class Node
    {
        ArrayList<String> key;
        Node left, right;

        
        
    /**
     * Node
     * @param ArrayList<String>
     * @author Alejandro Gomez y GeekForGeeks
     * @return n/a
     **/


        public Node(ArrayList<String> item)
        {
            key = item;
            left = right = null;
        }
    }
 
    // Root of BST
    Node root;
 
    // Constructor
    BinaryTree()
    {
         root = null;
    }
 
    
    /**
     * Insertar 
     * @param ArrayList<String>
     * @author Alejandro Gomez y GeekForGeeks
     * @return n/a
     */
    // This method mainly calls insertRec()
    void insertar(ArrayList<String> key)
    {
         root = insertRec(root, key);
    }
 
    
    /** 
     * AgregarR
     * @param Nodo
     * @param ArrayList<String>
     * @return Nodo
     * @author Alejandro Gomez y GeekForGeeks
     */
    /* A recursive function to
       insert a new key in BST */
    Node insertRec(Node root, ArrayList<String> key)
    {
 
        /* If the tree is empty,
           return a new node */
        if (root == null)
        {
            root = new Node(key);
            return root;
        }
 
        /* Otherwise, recur down the tree */
        if (key.get(0).compareTo(root.key.get(0))<0)
            root.left = insertRec(root.left, key);
        else if (key.get(0).compareTo(root.key.get(0))>0)
            root.right = insertRec(root.right, key);
 
        /* return the (unchanged) node pointer */
        return root;
    }
 
    

    // This method mainly calls InorderRec()
    void inorder()
    {
         inorderRec(root);
    }
 
    
    /** 
     * @param root
     */
    // A utility function to
    // do inorder traversal of BST
    void inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }
}