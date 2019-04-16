package JPHomework5;

public class SplitArrAppNew {
    //Глобальные переменные
    static final int SIZE = 10000000;
    static final int H = SIZE / 2;
    static float[] a2 = new float[H];
    static float[] a1 = new float[H];
    static float[] arr = new float[SIZE];

    //Однопоточный метод
    private static void SimpleArr(){
        System.out.println("Однопоточный метод вычисления");
        long a = System.currentTimeMillis();

        for (int i = 0; i < SIZE; i++){
            arr[i] = 1;
        }

        System.out.println("Время выполнения создания массива - " + (System.currentTimeMillis() - a) + " мс");
        long at = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }


        System.out.println("Время выполнения вычисления значений - " + (System.currentTimeMillis() - at) + " мс");
        System.out.println("*************************************************");
    }

    public static class MyThreadOne extends Thread {
        public void run() {
            System.out.println("Первый поток - пошел");
            long ot = System.currentTimeMillis();
            for (int j = 0; j < H; j++){
                a1[j] = (float)(a1[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
            }
            System.out.println("Время выполнения первого потока - " + (System.currentTimeMillis() - ot) + " мс");
        }
    }

    public static class MyThreadTwo extends Thread {
        public void run() {
            System.out.println("Второй поток - пошел");
            long tt = System.currentTimeMillis();
            for (int i = 0; i < H; i++){
                int ii = i + H;
                a2[i] = (float)(a2[i] * Math.sin(0.2f + ii / 5) * Math.cos(0.2f + ii / 5) * Math.cos(0.4f + ii / 2));
            }
            System.out.println("Время выполнения второго потока - " + (System.currentTimeMillis() - tt) + " мс");
        }
    }

    private static void TwoThread(){
        System.out.println("Двупоточный метод вычисления");
        long a = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++){
            arr[i] = 1;
        }
        long at = System.currentTimeMillis();
        System.arraycopy(arr,0,a1,0,H);
        System.arraycopy(arr,H,a2,0,H);

        MyThreadOne threadOne = new MyThreadOne();
        MyThreadTwo threadTwo = new MyThreadTwo();
        //запуск потоков
        threadOne.start();
        threadTwo.start();
        //ожидание окончания работы потоков
        try {
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException e){
            System.out.println("Главный поток прерван");
        }
        System.arraycopy(a1, 0, arr, 0, H);
        System.arraycopy(a2, 0, arr, H, H);
        System.out.println("Время работы двупоточного метода - " + (System.currentTimeMillis() - at) + " мс");

    }



    public static void main(String[] args) {
        SimpleArr();
        TwoThread();
    }

}
