package com.zzj.datastructure.linear;

/**
 * @author Jone
 * @version 1.0.0
 * @Description 线性表顺序存储
 * @createTime 2020年03月07日 18:17
 */
public class ArrayListDemo{

    /**
     * 默认容量
     */
    public static final int DEFAULT_CAPACITY = 10;
    /**
     * 顺序结构内部由数组实现
     */
    private Object[] items;
    /**
     * 数组里面最后加入数组元素的下标
     */
    private int size;

    public ArrayListDemo() {
        size = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public void add(Object obj){
        if(size() == items.length){
            ensureCapacity(size()*2+1);
        }
        items[size()] = obj;
        size++;
    }

    public void add(int index,Object obj){
        if(size() == items.length){
            ensureCapacity(size()*2+1);
        }
        for (int i = size; i > index; i--) {
            items[i] = items[i-1];
        }
        items[index] = obj;
        size++;
    }

    public Object get(int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        return items[index];
    }

    public Object remove(int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        Object item = items[index];
        for (int i = index; i < size; i++) {
            items[i] = items[i+1];
        }
        size--;
        return item;
    }

    public int size(){
        return size;
    }


    private void ensureCapacity(int capacity) {
        if(size > capacity){
            return;
        }
        Object[] old = items;
        items = new Object[capacity];
        for (int i = 0; i < size(); i++) {
            items[i] = old[i];
        }
    }
}
