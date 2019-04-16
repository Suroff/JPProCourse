package JPHomework5;

public class SplitArrApp {

    static final int size = 10000000;
    static final int h = size / 2;
    static long mTime1;
    static long mTime2;

    private static void SimpleArr(){
        System.out.println("Однопоточный метод вычисления");
        long a = System.currentTimeMillis();
        float[] arr = new float[size];
        for (int i = 0; i < size; i++){
            arr[i] = 1;
        }
//        System.out.println("Массив сформирован и заполненн единичками");
        System.out.println("Время выполнения создания массива - " + (System.currentTimeMillis() - a) + " мс");
        long at = System.currentTimeMillis();
        for (int i = 0; i < size; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

//        System.out.println("Массив переформирован");
        System.out.println("Время выполнения вычисления значений - " + (System.currentTimeMillis() - at) + " мс");
        System.out.println("*************************************************");
    }

    private static void TwoThreadArr(){


        System.out.println("Многопоточный метод вычисления");
        long a = System.currentTimeMillis();
        float[] arr = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        for (int i = 0; i < size; i++){
            arr[i] = 1;
        }
//        System.out.println("Массив сформирован и заполненн единичками");
        System.out.println("Время выполнения создания массива - " + (System.currentTimeMillis() - a) + " мс");
        long at = System.currentTimeMillis();
        System.arraycopy(arr,0,a1,0,h);
        System.arraycopy(arr,h,a2,0,h);

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < h; j++){
                    a1[j] = (float)(a1[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
                }
                  System.arraycopy(a1, 0, arr, 0, h);
                 mTime1 = System.currentTimeMillis() - at;
                 System.out.println(Thread.currentThread().getId() + " Время выполнения создания массива - " + mTime1 + " мс");

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < h; i++){
                    int ix = h + i;
                    a2[i] = (float)(a2[i] * Math.sin(0.2f + ix / 5) * Math.cos(0.2f + ix / 5) * Math.cos(0.4f + ix / 2));
                }

                  System.arraycopy(a2, 0, arr, h, h);
                  mTime2 = System.currentTimeMillis() - at;
                  System.out.println(Thread.currentThread().getId() + " Время выполнения создания массива - " + mTime2 + " мс");

            }
        }).start();
    }

    public static void main(String[] args) {
        SimpleArr();
        TwoThreadArr();

    }
}
