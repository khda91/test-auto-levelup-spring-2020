package lesson.java.introduction;

public class Arrays {

    public static void main(String[] args) {
        int[] intArray = new int[10];

        intArray[0] = 1;
        intArray[1] = 2;
        intArray[2] = 3;
        intArray[3] = 4;
        intArray[4] = 6;
        intArray[5] = 7;
        intArray[6] = 8;
        intArray[7] = 5;
        intArray[8] = 9;
        intArray[9] = 9;

        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + " ");
        }
        System.out.println();
        System.out.println("=================");
        System.out.println();

        String[][] stringsArray = new String[3][2];
        stringsArray[0][0] = "Long";
        stringsArray[0][1] = "Double";

        stringsArray[1][0] = "Int";
        stringsArray[1][1] = "Short";

        stringsArray[2][0] = "Float";

        for(int i = 0; i < stringsArray.length; i++) {
            for (int j = 0; j < stringsArray[i].length; j++) {
                System.out.print(stringsArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
