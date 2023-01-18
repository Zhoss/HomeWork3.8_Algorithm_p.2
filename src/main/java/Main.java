
public class Main {
    public static void main(String[] args) {
        int[] numbersBubble = generateRandomArray();
        int[] numbersSelection = generateRandomArray();
        int[] numbersInsertion = generateRandomArray();

        long startBubble = System.currentTimeMillis();
        sortBubble(numbersBubble);
        System.out.println("Время пузырьковой сортировки, мс");
        System.out.println(System.currentTimeMillis() - startBubble); // примерно 23 с

        long startSelection = System.currentTimeMillis();
        sortSelection(numbersSelection);
        System.out.println("Время сортировки выбором, мс");
        System.out.println(System.currentTimeMillis() - startSelection); // примерно 10 с

        long startInsertion = System.currentTimeMillis();
        sortInsertion(numbersInsertion);
        System.out.println("Время сортировки вставкой, мс");
        System.out.println(System.currentTimeMillis() - startInsertion); // примерно 2 с
    }

    public static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000);
        }
        return arr;
    }

    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    public static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    public static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    public static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
}
