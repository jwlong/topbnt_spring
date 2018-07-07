package com.dataStructure.quence;

/**
 * Created by longjinwen on 07/12/2017.
 */
public class QueueTest {
    public static void main(String[] args) {
        QueueArrImpl quence = new QueueArrImpl(10);

        for(int i = 0;i<5;i++){
//            Set<Integer> set = new TreeSet<Integer>();
//            set.add(i);
            quence.enQuence(i+1);
        }
        System.out.println(quence.getSize());
        System.out.println(quence.front());
        quence.traversal();
    }
}
