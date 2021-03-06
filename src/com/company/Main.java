package com.company;
//        /Создать массив потоков. Для вычисления факториала N.
//         каждый вычисляет факториал 10(Если компьютер не тянет - возьмите меньше).
//         Сделать с помощью потоков и без помощи потоков.
//         Замерить время выполнения(найти в интернете измерить время работы программы).
public class Main {
    public static long factorial(int number){
        if (number==1){
            return 1;
        }
        else {
            return (factorial(number - 1) * number);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        //Вычисление без потоков
        long startTime = System.nanoTime();
        System.out.println(factorial(3));
        long stopTime = System.nanoTime();
        System.out.println("Время работы: " + (stopTime - startTime)/1000);

        //Массив потоков
        long start = System.nanoTime();
        Runnable task = () -> {
            System.out.println(factorial(3));
        };
        Thread [] arr = new Thread[50];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Thread(task);
            arr[i].start();
            Thread.sleep(100);
        }
        long stop = System.nanoTime();
        System.out.println("Время работы: " + (stop - start)/1000);
    }
}