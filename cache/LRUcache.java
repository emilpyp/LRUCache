package az.week2.cache;
import java.util.Iterator;

public class LRUcache<T> implements Iterable<T>{
    T[] cache;
    int maxSize;
    int len;

    public LRUcache(int maxSize){
        this.cache = (T[]) (new Object[maxSize]);
        this.maxSize = maxSize;
        this.len = 0;
    }

    private void removeAndShift(){
        for(int i = 1; i < this.maxSize; i++){
            this.cache[i-1] = this.cache[i];
        }
    }

    public void addElement(T item){
        if(this.len == this.maxSize){
            this.removeAndShift();
            this.cache[len - 1] = item ;
        }
        else{
            this.cache[len++] = item;

        }
    }
    public T getElement(int index) throws IllegalAccessException {
        if(index < 0 || index >= this.len){
            throw new IllegalAccessException();
        }
        T element = this.cache[index];
        if(element == null) return null;
        return element;
    }

    void printAll(){
        System.out.print("[ ");
        for(int i = 0; i< this.len; i++){
            System.out.print(this.cache[i] + " ");
        }
        System.out.println("]\n");
    }

    class CacheIterator<T> implements Iterator<T>{
        T[] list;
        int cur = 0;

        CacheIterator(T[] cache){
            this.list = cache;
        }

        @Override
        public boolean hasNext() {
            return (this.list[cur] != null) && (this.list.length != cur);
        }

        @Override
        public T next() {
            return this.list[this.cur++];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new CacheIterator(this.cache);
    }
}
