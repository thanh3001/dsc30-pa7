import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class dHeapTester {

    dHeap<Integer> maxHeap1;
    dHeap<Integer> maxHeap2;
    dHeap<Integer> maxHeap3;


    @org.junit.Before
    public void setUp() {
        maxHeap1 = new dHeap<>();
        maxHeap2 = new dHeap<>(3, 10, true);
        maxHeap3 = new dHeap<Integer>(4, 20, true);

        maxHeap1.add(9);
        maxHeap1.add(5);

        /*for (Integer i=5; i<40;){
            maxHeap2.add(i);
            i+=5;
        }

        for (Integer i=3; i<30;){
            maxHeap3.add(i);
            i+=2;
        }*/
        System.out.println(maxHeap1.size());
    }

    @Test(expected = NullPointerException.class)
    public void TestNullPointerExceptionInAdd(){
        maxHeap1.add(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void TestNoSuchElementExceptionInRemove(){
        maxHeap2.remove();
    }

    @Test(expected = NoSuchElementException.class)
    public void TestNoSuchElementExceptionInElement(){
        maxHeap3.element();
    }

    @org.junit.Test
    public void testSize() {
        System.out.println(maxHeap1.size());
        /*assertTrue(maxHeap1.size()==2);
        maxHeap2.add(3);
        assertTrue(maxHeap2.size()==8);
        assertTrue(maxHeap3.size()==35);*/
    }

    @org.junit.Test
    public void testAdd() {
        maxHeap1.add(9);
        maxHeap1.add(5);
        assertTrue(maxHeap1.element()==9);
        maxHeap2.add(2);
        assertTrue(maxHeap2.size()==8);
        assertTrue(maxHeap2.element()==35);
        maxHeap3.add(6);
        assertTrue(maxHeap3.size()==15);
        assertTrue(maxHeap3.element()==29);
    }

    @org.junit.Test
    public void testRemove() {
        assertTrue(maxHeap1.remove()==9);
        assertTrue(maxHeap1.element()==5);
        assertTrue(maxHeap1.size()==1);

        assertTrue(maxHeap2.remove()==35);
        assertTrue(maxHeap2.element()==30);
        assertTrue(maxHeap2.size()==6);

        assertTrue(maxHeap3.remove()==29);
        assertTrue(maxHeap3.element()==27);
        assertTrue(maxHeap3.size()==13);
    }

    @org.junit.Test
    public void testClear() {
        assertTrue(maxHeap1.size()==0);

        assertTrue(maxHeap2.size()==0);

        assertTrue(maxHeap2.size()==0);

    }

    @org.junit.Test
    public void testElement() {

        assertTrue(maxHeap1.element()==9);

        assertTrue(maxHeap2.element()==35);

        assertTrue(maxHeap3.element()==29);
    }
}