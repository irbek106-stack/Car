import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        cycle: while (true) {
            System.out.println("==============MENU=============");
            System.out.println("1. Заполнить массив");
            System.out.println("2. Список автомобилей");
            System.out.println("3. Найти владельцев и номера по марке");
            System.out.println("4. Показать список популярных машин");
            System.out.println("5. Упорядочить марки по количеству");
            System.out.println("6. Выход");
            System.out.println("===============================");

            Scanner sc = new Scanner(System.in);
            int c = sc.nextInt();
            switch (c) {
                case 1:
                    Car.fillCar();
                    break;
                case 2:
                    Car.printCar();
                    break;
                case 3:
                    Car.findByMark();
                    break;
                case 4:
                    Car.mostPopularMark();
                    break;
                case 5:
                    Car.sortByMarkCount();
                    break;
                case 6:
                    break cycle;
                default:
                    System.out.println("Неверный пункт меню!");
            }
        }
    }
}