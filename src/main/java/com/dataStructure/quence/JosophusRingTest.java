package com.dataStructure.quence;

/**
 * Created by longjinwen on 07/12/2017.
 */
public class JosophusRingTest {
    public static void main(String[] args) {
        String[] kid = {"Alice", "Bob", "Cindy", "Doug", "Ed",
                "Fred", "Gene", "Hope", "Irene", "Jack",
                "Kim", "Lance", "Mike", "Nancy", "Ollie"};
       //将一组对象入列
        QueueArrImpl queueArr = new QueueArrImpl();
        for (int i=0;i<kid.length;i++){
            queueArr.enQuence(kid[i]);
        }
        Object o = handler(queueArr,5);
        System.out.println("最后的幸存者："+o);

    }
    public static  Object handler(QueueArrImpl queue,int k){
        while(queue.getSize() > 1){
            for(int i = 0 ;i< k ; i++){
                queue.enQuence(queue.deQuence());
            }
            Object e = queue.deQuence();
            System.out.println("\n\t"+e+" exit");
        }
        return queue.deQuence();
    }
}
