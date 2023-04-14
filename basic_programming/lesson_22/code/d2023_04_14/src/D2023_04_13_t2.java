public class D2023_04_13_t2 {
    public static void main(String[] args) {
//        Дано два массива, массив с именами студентов String[] students
//        второй массив int[] skipLessons, в котором указано сколько занятий пропустил соответствующий студент.
//        Т.е. если в первом массиве students[2]="jack", то skipLessons[2] содержжит количество прогуленных Джжеком занятий. Вам нужно реализовать:
//        - метод, который печатает всех студентов, у кого прогулов больше чем заданное число N
//                - метод, который создаст новый массив со строками вида:
//        "Jack прогулял 5 занятий"  для всех студентов, которые прогулмвали
//        "Nick не прогуливал" для всех, кто не прогуливал
        String[] students1 = new String[]{"Bob", "Frank", "Simon", "George", "Ivan"};
        int[] skipLessons1 = new int[]{1, 10, 3, 4, 0};
        int n = 3;
        printStudentsBySkips(students1, skipLessons1, n);

        String[] report1 = getReport(students1, skipLessons1);
        print(report1);

    }
    public static void print(String[] arr){
        for (int i =0; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    // 1. метод, который печатает всех студентов, у кого прогулов больше чем заданное число N
    public static void printStudentsBySkips(
            String[] students,
            int[] skippedLessons,
            int number
    ) {
        // печатать студентов у кого больше указанного количества пропусков
        for (int i = 0; i < students.length; i++) {
            if (skippedLessons[i] > number) {
                System.out.println(students[i]);
            }
        }
    }

    // 2. метод, который создаст новый массив со строками вида:
    ////        "Jack прогулял 5 занятий"  для всех студентов, которые прогуливали
    ////        "Nick не прогуливал" для всех, кто не прогуливал
    public static String[] getReport(String[] students, int[] skippedLessons) {
        String[] reportArray = new String[students.length];
        for (int i = 0; i < students.length; i++) {
            if (skippedLessons[i] > 0) {
                // первый вариант: "Jack прогулял 5 занятий"
                reportArray[i] = students[i] + " прогулял(а) " + skippedLessons[i] + " занятий";
            } else {
                // второй случай: "Nick не прогуливал"
                reportArray[i] = students[i] + " не прогуливал(a)";
            }
//            // другой вариант с тернарником
//            reportArray[i] =
//                    skippedLessons[i] > 0
//                            ? students[i] + " прогулял(а) " + skippedLessons[i] + " занятий"
//                            : students[i] + " не прогуливал";
        }
        return reportArray;
    }

}
