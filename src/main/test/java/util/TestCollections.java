package util;

import java.util.*;

/**
 * Created by longjinwen on 09/08/2017.
 */
public class TestCollections {
    public static void main(String[] args) {
       // containLists.add(list);
        List<SZObject> szObjects = new ArrayList<SZObject>();
        //szObjects = initData();
        szObjects = initData2();
        for(SZObject szObject : szObjects){
            System.out.println(szObject.getGroup()+","+szObject.getSize()+","+szObject.getSort());
        }
        List<SZObject>  normalList = new ArrayList<SZObject>(szObjects);
        System.out.println("After sort:....");
        sortData(szObjects);

        System.out.println("After sort: copy data....");
        print(normalList);
    }

    public static List<SZObject>  initData(){
        List<SZObject> list = new ArrayList<SZObject>();
        SZObject szObject = new SZObject();
        szObject.setGroup("shoes");
        szObject.setSize("45");
        szObject.setSort(2);

        SZObject szObject2 = new SZObject();
        szObject2.setGroup("shoes");
        szObject2.setSize("43");
        szObject2.setSort(1);

        SZObject szObject3 = new SZObject();
        szObject3.setGroup("shoes");
        szObject3.setSize("42");
        szObject3.setSort(3);
        list.add(szObject);
        list.add(szObject2);
        list.add(szObject3);
        return  list;
    }


    public static List<SZObject>  initData2(){
        List<SZObject> list = new ArrayList<SZObject>();
        SZObject szObject = new SZObject();
        szObject.setGroup("shoes1");
        szObject.setSize("45");
        szObject.setSort(2);

        SZObject szObject2 = new SZObject();
        szObject2.setGroup("shoes");
        szObject2.setSize("43");
        szObject2.setSort(1);

        SZObject szObject3 = new SZObject();
        szObject3.setGroup("shoes1");
        szObject3.setSize("42");
        szObject3.setSort(3);


        SZObject szObject4 = new SZObject();
        szObject4.setGroup("shoes");
        szObject4.setSize("45");
        szObject4.setSort(2);

        SZObject szObject5 = new SZObject();
        szObject5.setGroup("shoes");
        szObject5.setSize("43");
        szObject5.setSort(1);

        SZObject szObject6 = new SZObject();
        szObject6.setGroup("shoes");
        szObject6.setSize("42");
        szObject6.setSort(3);
        list.add(szObject4);
        list.add(szObject5);
        list.add(szObject6);



        list.add(szObject);
        list.add(szObject2);
        list.add(szObject3);

        return  list;
    }








    public static void testMin(int[] a){
         int min = a[0];
        for(int i = 1 ;i<a.length;i++){
                if(min >  a[i]){
                    min = a [i];
                }
        }
        System.out.println(min);
    }


    /**
     * shoes,45,2
     shoes,43,1
     shoes,42,3
     想变成
     shoes,43,1
     shoes,45,2
     shoes,42,3
     *
     *
     */
    public static void sortData(List<SZObject> oldList){
        Map map = new TreeMap();
        List<SZObject> newList = new ArrayList<SZObject>();
        int tmp = 0;
//        SZObject  minObject = oldList.get(0);
//        oldList.remove(minObject);

        Collections.sort(oldList,new DigitComparator());
//        for(SZObject szObject:oldList){
//            int x = szObject.getSort();
//            if(x  > minObject.getSort()){
//                minObject = szObject;
//            }
//        }
      //  System.out.println(minObject.getSort());
        print(oldList);
    }
    public static void print(List<SZObject> lists){
        for(SZObject szObject : lists){
            System.out.println(szObject.getGroup()+","+szObject.getSize()+","+szObject.getSort());
        }
    }
}

class  DigitComparator implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        SZObject szObject1= (SZObject)o1;
        SZObject szObject2 = (SZObject)o2;
        return  new Integer(szObject1.getSort()).compareTo(new Integer(szObject2.getSort()));
    }
}
