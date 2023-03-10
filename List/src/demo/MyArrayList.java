package demo;

import java.util.Arrays;

public class MyArrayList {

    public int[] elem;
    public int usedSize;//存储的有效数据
    public static final int DEFAULT_SIZE=10;

    public MyArrayList() {
        this.elem = new int[DEFAULT_SIZE];
    }
    public void display(){
        for (int i = 0; i <this.usedSize ; i++) {
            System.out.print(this.elem[i]);
        }
        System.out.println();
    }
    public int size(){
        return this.usedSize;
    }
    public boolean contains(int toFind){
        for (int i = 0; i <this.usedSize ; i++) {
            if (this.elem[i]==toFind){
                return true;
            }
        }
        return false;
    }

    public int indexof(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }
    public boolean isfull(){
        return this.usedSize==elem.length;
    }

    public void add(int data){
        if (this.isfull()){
            this.elem= Arrays.copyOf(this.elem,2*this.elem.length);
        }

        this.elem[this.usedSize]=data;
        this.usedSize++;
    }
    private void checkaddIndex(int pos){
        if (pos<0 || pos>usedSize){
            throw new IndexOutOfException("add元素的时候，位置不合法，请检查位置的合法性");
        }
    }
    private void checkGetIndex(int pos){
        if (pos<0 || pos>=usedSize){
            throw new IndexOutOfException("add元素的时候，位置不合法，请检查位置的合法性");
        }
    }
    public void add(int pos, int data) {
        checkaddIndex(pos);
        if (this.isfull()){
            this.elem= Arrays.copyOf(this.elem,2*this.elem.length);
        }
            for (int i = usedSize - 1; i >= pos; i--) {
                this.elem[i + 1] = this.elem[i];
            }
            this.usedSize++;
            this.elem[pos] = data;

    }
    public int get (int pos){
        checkGetIndex(pos);
        return this.elem[pos];
    }

    public void set(int pos,int value){
        checkaddIndex(pos);
        elem[pos]=value;
    }
    public boolean remove(int toRemove){
        int index = indexof(toRemove);
        if (index==-1){
            System.out.println("没这个数据");
            return false;
        }
        for (int i = index; i <usedSize-1 ; i++) {
            elem[i]=elem[i+1];
        }
        usedSize--;
        elem[usedSize]=0;
        return true;
    }


}
