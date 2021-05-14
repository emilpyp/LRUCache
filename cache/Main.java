package az.week2.cache;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        LRUcache<Integer> myCache = new LRUcache<>(10);
        for(int i = 0; i<5; i++){
            myCache.addElement(i);
        }
        myCache.printAll();
        System.out.println();
        myCache.getElement(0);
        System.out.println(myCache.getElement(4));

        for(int i: myCache){
            System.out.println(i);
        }
    }
}
