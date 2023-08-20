package org.boss.linkedlist;


public class LinkedList {
    private class Node {
        private int data;
        private Node next;
        
        
        public Node(int data) {
            this.data = data;
        }
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.size = 0;
    }

    public void addFirst(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
        if (tail == null)
            tail = head;
        size += 1; 
    }
    public void add(int idx, int data){
        if(idx == 0){
            addFirst(data);
            return;
        }
        if(idx == size){
            addLast(data);
            return;
        }
        
        Node curr = head;
        for(int i = 0; i < idx; i++){
            curr = curr.next;
        }
        Node node = new Node(data, curr.next);
        curr.next = node;
        size += 1;
    }
    public void addLast(int data){
        if(tail == null){
            addFirst(data);
            return;
        }
        Node node = new Node(data);
        tail.next = node;
        tail = node;
        size += 1;
    }
    public int deleteFirst(){
        int data = head.data;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size -= 1;
        return data;
    }
    public int deleteLast(){
        if(size <= 1){
            return deleteFirst();
        }
        Node curr = head, prev = null;
        while(curr.next != null){
            prev = curr;
            curr = curr.next;
        }
        int data = curr.data;
        prev.next = null;
        tail = prev;
        size -= 1;
        return data;
    }
    public int delete(int idx){
        if(idx == 0){
            return deleteFirst();
        }
        if(idx == size){
            return deleteLast();
        }
        Node curr = head, prev = null;
        for(int i = 1; i <= idx; i++){
            prev = curr;
            curr = curr.next;
        }
        int data = curr.data;
        prev.next = curr.next;
        size -= 1;
        return data;
    }
    public void print(){
        Node tmp = head;
        while(tmp != null){
            System.out.print(tmp.data+ " ");
            tmp = tmp.next;
        }
        System.out.println("END");
    }

}
