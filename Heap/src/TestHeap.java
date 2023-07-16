import java.util.Arrays;

public class TestHeap {
    public int[] elem;
    public int usedSize;

    public TestHeap() {
        this.elem = new int[10];
    }

    public void initElem(int[] array){
        for (int i = 0; i < array.length; i++) {
            elem[i] = array[i];
            usedSize++;
        }
    }
    public void createHeap(){
        for (int parent = (usedSize-1-1)/2; parent >=0; parent--) {
            shiftDown(parent,usedSize);
        }
    }

    //parent 父亲节点下标
    //len 每棵树结束下标
    //向下调整时间复杂度是N
    private void shiftDown(int parent , int len){
        int child = 2*parent+1;
        while (child<len){

            if (child+1<len && elem[child] < elem[child+1]){
                child++;
            }

            if (elem[child] > elem[parent]){
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                parent=child;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }

    public void shiftUp(int child){

        int parent = (child-1)/2;

        while (child>0){

            if (elem[child]>elem[parent]){
                swap(elem , child,parent);
                child = parent;
                parent = (child-1)/2;
            }else {
                break;
            }
        }
    }
    //向上调整的时间复杂度为N*logN
    public void offer(int val){
        if(isFull()){
            elem = Arrays.copyOf(elem,2*elem.length);
        }
        elem[usedSize++] = val;

        shiftUp(usedSize-1);
    }

    public boolean isFull(){
        return usedSize == elem.length;
    }

    public void pop(){
        if (isEmpty()){
            return;
        }
        swap(elem,0,usedSize-1);
        usedSize--;
        shiftDown(0,usedSize);
    }

    public boolean isEmpty(){
        return usedSize == 0;
    }

    public void swap(int[] array ,int i ,int j){
        int tmp = elem[i];
        elem[i] = elem[j];
        elem[j] = tmp;
    }


}
    