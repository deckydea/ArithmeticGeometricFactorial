import java.util.Scanner;

public class ArithmeticGeometricFactorial {
    static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int sizeNumber;
        int difNumber;

        while (true) {
            System.out.println("\n       Belajar Deret Aritmatika, Geometri dan menghitung Faktorial");

            System.out.print("Masukan banyak angka yang mau dicetak [2...10]: ");
            sizeNumber = input.nextInt();

            //Validate the size of a number, must be greater than 2 and less than 10
            if (validateLength(sizeNumber, 2, 10)) {
                System.out.println("Banyak angka tidak sesuai. Banyak angka minimal 2 dan maksimal 10\n");

                //Confirm if the user want to repeat the input
                if (confirmIsRepeat()) continue;
                else return;
            }


            while (true) {
                System.out.print("Masukan beda masing-masing angka [2...9]: ");
                difNumber = input.nextInt();

                //Validate the size of a number, must be greater than 2 and less than 10
                if (validateLength(difNumber, 2, 9)) {
                    System.out.println("Banyak beda masing-masing angka tidak sesuai. Banyak beda masing-masing angka minimal 2 dan maksimal 9\n");

                    //Confirm if the user want to repeat the input
                    if (confirmIsRepeat()) continue;
                    else return;
                }
                break;
            }

            //Empty line
            System.out.println("");

            populateArithmetic(sizeNumber, difNumber);
            populateGeometric(sizeNumber, difNumber);
            populateFactorial(sizeNumber);

            //Confirm if the user want to repeat the program
            if (!confirmIsRepeat()) System.exit(0);
        }
    }

    private static void populateFactorial(int sizeNumber) {
        System.out.printf("Faktorial dari %s: \n", sizeNumber);

        int total = 1;
        while (sizeNumber >= 1) {
            total *= sizeNumber;

            if (sizeNumber == 1) {
                System.out.printf("%s = %s", sizeNumber, total);
            } else {
                System.out.print(sizeNumber + " * ");
            }

            sizeNumber--;
        }

        //Empty line
        System.out.println("\n");
    }

    private static void populateGeometric(int sizeNumber, int difNumber) {
        System.out.println("Deret Geometri: ");
        int current = 1;
        for (int i = 1; i <= sizeNumber; i++) {
            System.out.print(current + " ");
            current *= difNumber;
        }

        //Empty line
        System.out.println("\n");
    }

    private static void populateArithmetic(int sizeNumber, int difNumber) {
        System.out.println("Deret Aritmatika: ");
        int current = 1;
        for (int i = 1; i <= sizeNumber; i++) {
            System.out.print(current + " ");
            current += difNumber;
        }

        //Empty line
        System.out.println("\n");
    }

    private static boolean confirmIsRepeat() {
        boolean isRepeat;

        while (true) {
            System.out.print("Anda mau ulang? [y/t] : ");
            String value = input.next();

            if (value.equals("y") || value.equals("Y")) {
                isRepeat = true;
                input.nextLine();

                //More space
                System.out.println();
                break;
            } else if (value.equals("t") || value.equals("T")) {
                isRepeat = false;
                break;
            } else {
                System.out.println("Silahkan ketik 'y' untuk mengulang atau 't' untuk mengakhiri");
            }
        }

        return isRepeat;
    }

    //Validating the length or size
    private static boolean validateLength(int lengthValue, int minLength, int maxLength) {
        return lengthValue < minLength || lengthValue > maxLength;
    }

}