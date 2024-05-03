/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colaprioridad3;

import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class BST<Key extends Comparable<Key>, Value> implements Iterable<Key> {

    //Apuntador o referencia a la raiz
    private Nodo root;

    //Nodo arbol binario
    private class Nodo {

        private Key key;
        private Value value;
        private Nodo left, right;

        //Constructores
        public Nodo() {
            this.key = null;
            this.value = null;
            this.left = null;
            this.right = null;
        }

        public Nodo(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
        //Un arbol binario es:
        // null
        // o un nodo con hijo izquierdo e hijo derecho
        //     

    }
    
    
    public BST() {
        this.root = null;
    }

    public BST(Nodo root) {
        this.root = root;
    }
    public Nodo max(){
         return max(root);
    }
    
   public Nodo max(Nodo max){
       if(max.right==null){
           System.out.println("La key mayot es " + max.key + " y su valor es " + max.value);
       return max;
       }    
        else {   
           max(max.right);
           return max;
       }
   
   }
   
   public Nodo min(){
       return min(root);
       
   }
   public Nodo min(Nodo min){
    if(min.left==null){
           System.out.println("La key menor es " + min.key + " y su valor es " + min.value);
       return min;
       }else{
    min(min.left);
           return min;
    }
  
   
   }
   
   
   public Nodo piso(Key llave){
       
    return piso(root,llave);
   }
   
   
   public Nodo piso(Nodo piso, Key llave){

if(piso.left==null){
    System.out.println("La Key menor o = es " + piso.key + " y su valor es " + piso.value);
   return piso;
}
       int comp=piso.key.compareTo(piso.right.key);
       
   if(llave.equals(piso.key)){
      System.out.println("La Key menor o = es " + piso.key + " y su valor es " + piso.value);
      piso(piso.left,llave);
       return piso;
   }else{
       piso(piso.left,llave);
   return piso;
   }
   }
   
    public void put(Key key, Value value) {
        root = put(new Nodo(key, value), root);

    }

    public Nodo put(Nodo nodo, Nodo raiz) {
        if (raiz == null) {
            return nodo;
        }
        int cmp = nodo.key.compareTo(raiz.key);
        if (cmp < 0) {
            raiz.left = put(nodo, raiz.left);
        } else {
            raiz.right = put(nodo, raiz.right);
        }
        return raiz;
    }

    public Value get(Key key) {

        return get(key, root);

    }

    public Value get(Key key, Nodo raiz) {
        if (raiz == null) {
            return null;
        }
        int cmp = key.compareTo(raiz.key);
        if (cmp == 0) {
            return raiz.value;
        }
        if (cmp < 0) {
            return get(key, raiz.left);
        }
        return get(key, raiz.right);

    }

    public void delete(Key key) {

        Nodo actual=root;
        root=delete(key,actual);
    }
    
    public boolean esHoja(Nodo raiz){
        if (raiz.left ==null && raiz.right==null)
            return true;
        return false;
    }
    
    public Nodo delete(Key key, Nodo raiz){
        if(raiz==null){
            System.out.println("Elemento no encontrado");
            raiz= null;
        } else {
        int cmp = key.compareTo(raiz.key);
        if (cmp == 0) {
           //consideracion de eliminacion
           //El nodo es hoja
            System.out.println("Elemento encontrado");
           if (esHoja(raiz)){
               System.out.println("Es hoja");
               raiz= null;
           } else
           //Uno de los hijos es null
           if(raiz.left==null){
               System.out.println("hijo izquierdo vacio");
               raiz= raiz.right;
           } else
           if (raiz.right==null){
               System.out.println("hijo derecho vacio");
               raiz= raiz.left;
           }
           //Ambos hijos tienen subarboles
          
        } else
        if (cmp < 0) {
            raiz.left= delete(key, raiz.left);
        }else {
           raiz.right= delete(key, raiz.right);
        }
        }
        return raiz;
    }

    public boolean contains(Key key) {
        return false;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return size(root);
    }

    public int size(Nodo raiz) {
        if (raiz == null) {
            return 0;
        }
        return 1 + size(raiz.left) + size(raiz.right);
    }

    //Iterador
    public Iterator<Key> iterator() {
        return new BinaryIterator();
    }

    private class BinaryIterator implements Iterator<Key> {

        private Nodo actual = root;

        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public Key next() {
            return null;
        }
    }

    public void mostrarDatos(Nodo raiz) {
        if (raiz == null) {
            return;
        }
        mostrarDatos(raiz.left);
        System.out.println("llave " + raiz.key + " valor " + raiz.value);
        mostrarDatos(raiz.right);
    }

    public void mostrarDatos() {
        System.out.println("--------------------");
        mostrarDatos(root);
    }

}
