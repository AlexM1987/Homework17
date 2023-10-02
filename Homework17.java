// Создаем класс, который реализует интерфейс Runnable
class MyRunnable implements Runnable {
    // Задаем поле для хранения задержки при выполнении
    private int delay;
    // Задаем поле для хранения имени потока
    private String name;
    // Создаем конструктор с параметрами
    public MyRunnable(int delay, String name) {
        this.delay = delay;
        this.name = name;
    }
    // Переопределяем метод run, который будет выполняться в потоке
    @Override
    public void run() {
// Выводим сообщение о запуске потока
        System.out.println("Поток " + name + " запущен");
        try {
// Имитируем выполнение какой-то работы с помощью Thread.sleep
            Thread.sleep(delay);
// Выводим сообщение о выполнении потока
            System.out.println("Поток " + name + " выполнил работу");
        } catch (InterruptedException e) {
// Обрабатываем исключение, если поток был прерван
            System.out.println("Поток " + name + " был прерван");
        }
// Выводим сообщение о завершении потока
        System.out.println("Поток " + name + " завершен");
    }
}

// Создаем класс, который наследует класс Thread
class MyThread extends Thread {
    // Задаем поле для хранения задержки при выполнении
    private int delay;
    // Задаем поле для хранения имени потока
    private String name;
    // Создаем конструктор с параметрами
    public MyThread(int delay, String name) {
        this.delay = delay;
        this.name = name;
    }
    // Переопределяем метод run, который будет выполняться в потоке
    @Override
    public void run() {
// Выводим сообщение о запуске потока
        System.out.println("Поток " + name + " запущен");
        try {
// Имитируем выполнение какой-то работы с помощью Thread.sleep
            Thread.sleep(delay);
// Выводим сообщение о выполнении потока
            System.out.println("Поток " + name + " выполнил работу");
        } catch (InterruptedException e) {
// Обрабатываем исключение, если поток был прерван
            System.out.println("Поток " + name + " был прерван");
        }
// Выводим сообщение о завершении потока
        System.out.println("Поток " + name + " завершен");
    }
}

// Создаем основной класс программы
public class Homework17 {
    public static void main(String[] args) {
// Создаем объект Runnable с задержкой в 100 миллисекунд и именем A
        Runnable runnableA = new MyRunnable(100, "A");
// Создаем объект Thread с задержкой в 500 миллисекунд и именем B
        Thread threadB = new MyThread(500, "B");
// Создаем объект Thread с параметром runnableA и именем C
        Thread threadC = new Thread(runnableA, "C");

// Запускаем три потока разными способами:

// Первый способ: вызываем метод start у объекта Thread
        threadB.start();

// Второй способ: создаем объект Thread с параметром Runnable и вызываем метод start у него
        new Thread(runnableA).start();

// Третий способ: вызываем статический метод execute у класса ExecutorService с параметром Runnable
        java.util.concurrent.ExecutorService executor = java.util.concurrent.Executors.newSingleThreadExecutor();
        executor.execute(threadC);

// Завершаем работу ExecutorService
        executor.shutdown();
    }
}
