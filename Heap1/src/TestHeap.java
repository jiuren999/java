import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        // 找倒数第一个非叶子节点，从该节点位置开始往前一直到根节点，遇到一个节点，应用向下调整
        for (int parent = (usedSize-1-1)/2; parent >=0; parent--) {
            shiftDown(parent,usedSize);
        }
    }

    //parent 父亲节点下标
    //len-1 每棵树结束下标
    //向下调整时间复杂度是O(N)
    private void shiftDown(int parent , int len){
        // child先标记parent的左孩子，因为parent可能有左孩子没有右孩子
        int child = 2*parent+1;
        while (child<len){
        // 如果右孩子存在，找到左右孩子中较大的孩子,用child进行标记
            if (child+1<len && elem[child] < elem[child+1]){
                child++;
            }
            // 将双亲与较大的孩子交换
            if (elem[child] > elem[parent]){
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
            // parent中大的元素往下移动，可能会造成子树不满足堆的性质，因此需要继续向下调整
                parent=child;
                child = 2*parent+1;
            }else {// 如果双亲比其最小的孩子还小，说明该结构已经满足堆的特性了
                break;
            }
        }
    }

    //小根堆
    private void shiftDown1(int parent , int len){
        // child先标记parent的左孩子，因为parent可能有左孩子没有右孩子
        int child = 2*parent+1;
        while (child<len){
            // 如果右孩子存在，找到左右孩子中较小的孩子,用child进行标记
            if (child+1<len && elem[child] > elem[child+1]){
                child++;
            }
            // 将双亲与较小的孩子交换
            if (elem[child] < elem[parent]){
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                // parent中大的元素往下移动，可能会造成子树不满足堆的性质，因此需要继续向下调整
                parent=child;
                child = 2*parent+1;
            }else {// 如果双亲比其最小的孩子还小，说明该结构已经满足堆的特性了
                break;
            }
        }
    }

    public void shiftUp(int child){

        int parent = (child-1)/2;

        while (child>0){

            if (elem[child]<elem[parent]){
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



    public void  heapSort(){
        int end = usedSize-1;
        while (end>0) {
            swap(elem ,0 ,end);
            shiftDown1(0 ,end);
            end--;
        }
    }


    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else {
                int val = map.get(nums[i]);
                map.put(nums[i] , val+1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == 1){
                return nums[i];
            }
        }
        return -1;
    }

}

