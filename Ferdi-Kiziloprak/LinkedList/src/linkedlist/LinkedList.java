/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package linkedlist;

/**
 *
 * @author FerdiKT
 * @param <T> AnyObject
 */
public class LinkedList<T> {
    
    Node<T> head;
    
    public LinkedList(){

    }
    public LinkedList(T data){
        head = new Node(data);
        head.next = null;
    }
    
    public void addFirst(T data){
        Node<T> newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        
    }
    
    public void addLast(T data){
        if (head == null) {
            addFirst(data);
        }else{
            Node<T> temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = new Node(data);
        }
        
    }
    
    public int size(){
        int counter = 0;
        Node<T> temp = head;
        while(temp!=null){
            temp = temp.next;
            counter++;
        }
        return counter;
    }
    
//    public T sum(){
//        T sum;
//        Node<T> temp = head;
//        while(temp!=null){
//            //sum = sum + temp.data;
//        }
//        return sum;
//    }
    
    public void addByIndex(int index, T data){
        Node<T> newNode = new Node<>(data);
        if(index == 0 || head == null){
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> temp = head;
            int counter = 1;
            while (counter != index) {
                temp = temp.next;
                counter++;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }
    
    public void addByValue(T data, T data2){
        Node<T> temp = head;
        while (temp.data != data) {
            temp = temp.next;
        }
        Node<T> newNode = new Node<>(data2);
        newNode.next = temp.next;
        temp.next = newNode;
    }
    
    public T getLast(){
        Node<T> temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        return temp.data;
    }
    
    public void removeByIndex(int index){
        if(index == 0){
            head = null;
        } else {
            Node<T> temp = head;
            int counter = 1;
            while (counter != index && temp.next != null) {
                temp = temp.next;
                counter++;
            }
            temp = temp.next;
        }
    }
    
    public void printList(){
        Node<T> temp = head;
        if (head.data == null) {
            throw new MyException("null");
        }
        else { 
            do{             
                System.out.print(temp.data + "=>");
                temp = temp.next;
            }while(temp!=null);
        }
        System.out.println("null");
    }
}

class MyException extends RuntimeException{

    public MyException(String str) {
        super(str);
    }
    
}
