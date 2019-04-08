package JPLesson3;

import java.lang.reflect.Array;
import java.util.*;

public class CollectionApp {

    public static void main(String[] args){

        List<Integer> arrList = new ArrayList<>();
        for (int i=0; i<10; i++){
            arrList.add(i * 10);
        }

        System.out.println(arrList);

        for (int i=0; i<5; i++){
            arrList.add(i * 10);
        }

        System.out.println(arrList);
        System.out.println(arrList.size());
        System.out.printf("Элемент по индексу [%d]: %d%n",4,arrList.get(5));


        arrList.remove(1);

        System.out.println(arrList);
        System.out.println(arrList.size());

        for (Integer val : arrList){
            System.out.printf("Элемент по индексу %d%n",val);
        }

        //2List двумерный массив
        List<List<Integer>> TwoDimArrList = new ArrayList<>();
        TwoDimArrList.add(new ArrayList<>());
        TwoDimArrList.get(0).add(23);

        //Linked List и Queue
        System.out.println("Работа с очередью");
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        //Map and other stuff
        Map<String,String> dictionary = new HashMap<>();
        dictionary.put("Hello","Привет йопта");
        dictionary.put("Hello", "Здрасте");
        dictionary.put("Bye","Пока йопта");
        dictionary.put("I","Я");

        String word = "Hello";
        System.out.printf("%s - %s%n",word,dictionary.get(word));

        //Map and link (если нужно несколько слов)
        //MultiMap собственной персоной
        Map<String,List<String>> dic2 = new HashMap<>();

        //Множества
        Set<String> userRules = new HashSet<>();
        userRules.add("read");
        userRules.add("write");

        System.out.println("Права на чтение " + userRules.contains("read"));
        System.out.println("Права на запись " + userRules.contains("write"));
        System.out.println("Права на чтение/запись " + userRules.contains("read/write"));

        //Элементы отсортированы
        Set<Integer> setT = new TreeSet<>();
        for (int i=15; i>1;i--){
            setT.add(i*10);
        }

        setT.add(81);

        for (Integer iVal : setT){
            System.out.println(iVal);
        }
        System.out.println("*********************");

        //Элементы просто по порядку добавления
        Set<Integer> setL = new LinkedHashSet<>();
        for (int i=15; i>1;i--){
            setL.add(i*10);
        }

        setL.add(81);

        for (Integer iVal1 : setL){
            System.out.println(iVal1);
        }
        System.out.println("*********************");

        //Элементы в хаосе
        Set<Integer> setH = new HashSet<>();
        for (int i=15; i>1;i--){
            setH.add(i*10);
        }

        setH.add(81);

        for (Integer iVal2 : setH){
            System.out.println(iVal2);
        }

        List<Object> eList = Collections.emptyList();
        List<String> sList = Arrays.asList("1","22","333");

        int[] intArr = new int[100];
        List<int[]> ints = Arrays.asList(intArr);


    }
}
