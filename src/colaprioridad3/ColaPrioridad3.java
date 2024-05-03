/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package colaprioridad3;

/**
 *
 * @author Acer
 */
public class ColaPrioridad3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BST bst=new BST();
        //adicionamos 
        bst.put(5, 5);
        bst.put(2, 8);
        bst.put(2, 9);
        bst.put(8, 1);
      
        //maximo
        bst.mostrarDatos();
        bst.max();
        bst.min();
        bst.piso(2);
    }
    
}
