import java.util.Scanner;

public class Car {
    private String mark;
    private String number;
    private String lastname;
    private static Car[] automobile;

    static {
        automobile = new Car[] {
                new Car("Toyota", "H999HH 15 RUS", "Фидаров"),
                new Car("BMW", "А123АВ 777 RUS","Джонсович"),
                new Car("Toyota", "М806КК 99 RUS", "Спопович"),
                new Car("LADA", "Р015СО 77 RUS", "Абаев"),
                new Car("McLaren", "Р016СО RSO", "Таймазов"),
                new Car("Porsche", "А345РС RSO", "Келихсаев"),
                new Car("LADA", "Р060НМ 15 RUS", "Абаев"),
                new Car("LADA", "Р100CМ 05 RUS", "Азикаев"),
        };
    }

    public Car(String mark, String number, String lastname) {
        this.mark = mark;
        this.number = number;
        this.lastname = lastname;
    }

    public Car() {
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.println("Марка машины: ");
        this.setMark(sc.nextLine());
        System.out.println("Номер машины: ");
        this.setNumber(sc.nextLine());
        System.out.println("Фамилия владельца автомобиля: ");
        this.setLastname(sc.nextLine());
    }

    public String toString() {
        return String.format("Марка: %s Номер: %s Владелец: %s", mark, number, lastname);
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        if (mark == null || mark.isEmpty()) {
            System.out.println("Недопустимое значение");
        } else {
            this.mark = mark;
        }
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if (number == null || number.isEmpty()) {
            System.out.println("Недопустимое значение");
        } else {
            this.number = number;
        }
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        if (lastname == null || lastname.isEmpty()) {
            System.out.println("Недопустимое значение");
        } else {
            this.lastname = lastname;
        }
    }

    public static void fillCar() {
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.println("Введите количество автомобилей => ");
        int n = sc.nextInt();
        sc.nextLine();

        automobile = new Car[n];

        System.out.println("Введите информацию об автомобилях: ");

        for (int i = 0; i < automobile.length; i++) {
            System.out.println("\n Автомобиль " + (i + 1) + " =>");
            automobile[i] = new Car();
        }
    }

    public static void printCar() {
        System.out.println("\n Список автомобилей: ");
        for (int i = 0; i < automobile.length; i++) {
            System.out.println(automobile[i]);
        }
    }

    public static void findByMark() {
        Scanner sc = new Scanner(System.in, "cp1251");

        System.out.println("\n Введите марку автомобиля => ");
        String mark = sc.nextLine();

        boolean found = false;

        System.out.println("\n Автомобили марки" + mark + ":");
        for (Car a : automobile) {
            if(a.getMark().equalsIgnoreCase(mark)) {
                System.out.println("Владелец" + a.getLastname() + ", номер" + a.getNumber());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Автомобиль такой марки не найден");
        }
    }

    public static void mostPopularMark() {
        if (automobile.length == 0) {
            System.out.println("Массив автомобилей пуст.");
            return;
        }
        String popularMark = automobile[0].getMark();
        int maxCount = 0;

        for (int i = 0; i < automobile.length; i++) {
            int count = 0;

            for (int j = 0; j < automobile.length; j++) {
                if (automobile[i].getMark()
                        .equalsIgnoreCase(automobile[j].getMark())) {
                    count++;
                }
            }
        }
    }

    public static void sortByMarkCount() {
        String[] marks = new String[automobile.length];
        int[] counts = new int[automobile.length];

        int markCount = 0;

        for (int i = 0; i < automobile.length; i++) {
            boolean exists = false;

            for (int j = 0; j < markCount; j++) {
                if (marks[j].equalsIgnoreCase(automobile[i].getMark())) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                marks[markCount] = automobile[i].getMark();

                for (int j = 0; j < automobile.length; j++) {
                    if (automobile[j].getMark()
                            .equalsIgnoreCase(automobile[i].getMark())) {
                        counts[markCount]++;
                    }
                }
                markCount++;
            }
        }
        for (int i = 0; i < markCount - 1; i++) {

            for (int j = 0; j < markCount - 1 - i; j++) {
                if (counts[j] < counts[j + 1]) {
                    int tempCount = counts[j];
                    counts[j] = counts[j + 1];
                    counts[j + 1] = tempCount;

                    String tempMark = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = tempMark;
                }
            }
        }
        System.out.println("\n Марки автомобилей по убыванию количества: ");
        for (int i = 0; i < markCount; i++) {
            System.out.println(marks[i] + " - " + counts[i] + "автомобилей");
        }
    }
}
