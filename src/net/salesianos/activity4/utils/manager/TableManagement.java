package net.salesianos.activity4.utils.manager;

import java.io.Serializable;

public class TableManagement<T> implements Serializable{
    private T[] list;
    private int size;

    @SuppressWarnings("unchecked")
    public TableManagement() {
        this.list = (T[]) new Object[0];
        this.size = this.list.length;
    }

    @SuppressWarnings("unchecked")
    public void add(T element) {
        Object[] otherList = new Object[size + 1];
        for (int i = 0; i < this.size; i++) {
            otherList[i] = list[i];
        }
        otherList[size] = element;
        this.list = (T[]) otherList;
        this.size = this.list.length;
    }

    public int size() {
        return this.size;
    }

    public T get(int index) {
        if (index < this.size) {
            return this.list[index];
        }
        return null;
    }

    public boolean contains(T param) {
        for (T element : list) {
            if (element.equals(param)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(T element) {
        for (int index = 0; index < this.size; index++) {
            if (list[index] != null && list[index].equals(element)) {
                return index;
            }
        }
        return -1;
    }

    public int lastIndexOf(T param) {
        for (int index = this.size - 1; index >= 0; index--) {
            if (this.list[index].equals(param)) {
                return index;
            }
        }
        return -1;
    }

    public boolean remove(int index) {
        if (this.list[index] != null) {
            this.list[index] = null;
            return true;
        }
        return false;
    }

    public boolean remove(T param) {
        int index = this.indexOf(param);
        if (index == -1) {
            return false;
        }
        return this.remove(index);
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        this.list = (T[]) new Object[0];
    }

    public boolean isEmpty() {
        for (T element : this.list) {
            if (element != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append("\nMesa Nº " + (i + 1) + list[i].toString() + "\n");
        }
        
        return sb.toString();
    }
}
