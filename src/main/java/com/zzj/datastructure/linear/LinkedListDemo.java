package com.zzj.datastructure.linear;

/**
 * @author Jone
 * @version 1.0.0
 * @Description 手写链式存储
 * @createTime 2020年03月08日 00:12
 */
public class LinkedListDemo {
    /**
     * 链表中节点个数
     */
    private int size;
    private int modeCount = 0;
    private Node first;
    private Node end;

    public LinkedListDemo() {
        size = 0;
        modeCount++;
        first = new Node(null,null,null);
        end = new Node(null,first,null);
        first.next = end;
    }

    public void add(Object obj){
        Node node = new Node(obj, end.prev, end);
        end.prev.next = node;
        end.prev = node;
        modeCount++;
        size++;
    }

    public Object remove(int index){
        Node node = getNode(index);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
        modeCount--;
        return node.data;
    }

    public Object get(int index){
        return getNode(index);
    }

    public Node getNode(int index){
        Node p;
        if(index<0||index>size){
            throw new IndexOutOfBoundsException();
        }
        if(index < size/2){
            p = first.next;
            for (int i = 0; i < index; i++) {
                p = first.next;
            }
        }else{
            p = end.prev;
            for (int i = size; i >index ; i--) {
                p = end.prev;
            }
        }

        return p;
    }

    static class Node{
        private Object data;
        private Node prev;
        private Node next;

        public Node(Object data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
}
