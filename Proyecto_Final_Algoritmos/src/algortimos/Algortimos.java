package algortimos;
import java.util.*;
public class Algortimos {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcionAlgoritmo;
        do {
            System.out.println("Elija un algoritmo de ordenamiento:");
            System.out.println("1. Bubblesort");
            System.out.println("2. Cocktailsort");
            System.out.println("3. Insertionsort");
            System.out.println("4. Bucketsort");
            System.out.println("5. Countingsort");
            System.out.println("6. Mergesort");
            System.out.println("7. Binarytreesort");
            System.out.println("8. Pigeonhole");
            System.out.println("9. Radixsort");
            System.out.println("10. Shellsort");
            System.out.println("11. Selectionsort");
            System.out.println("12. Quicksort");
            System.out.println("0. Salir");

            opcionAlgoritmo = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcionAlgoritmo) {
                case 1:
                    // Bubblesort
                    int[] bubbleArray = leerArreglo();
                    bubblesort(bubbleArray);
                    break;

                case 2:
                    // Cocktailsort
                    int[] cocktailArray = leerArreglo();
                    cocktailsort(cocktailArray);
                    break;

                case 3:
                    // Insertionsort
                    int[] insertionArray = leerArreglo();
                    insertionsort(insertionArray);
                    break;

                case 4:
                    // Bucketsort
                    int[] bucketArray = leerArreglo();
                    bucketsort(bucketArray);
                    break;

                case 5:
                    // Countingsort
                    int[] countingArray = leerArreglo();
                    countingsort(countingArray);
                    break;

                case 6:
                    // Mergesort
                    int[] mergeArray = leerArreglo();
                    mergesort(mergeArray, 0, mergeArray.length - 1);
                    System.out.println("Arreglo ordenado: " + Arrays.toString(mergeArray));
                    break;

                case 7:
                    // Binarytreesort
                    //int[] binaryTreeArray = leerArreglo();
                    //binarytreesort(binaryTreeArray);
                    break;

                case 8:
                    // Pigeonhole
                    int[] pigeonholeArray = leerArreglo();
                    pigeonholesort(pigeonholeArray);
                    break;

                case 9:
                    // Radixsort
                    int[] radixArray = leerArreglo();
                    radixsort(radixArray);
                    break;

                case 10:
                    // Shellsort
                    int[] shellArray = leerArreglo();
                    shellsort(shellArray);
                    System.out.println("Arreglo ordenado: " + Arrays.toString(shellArray));
                    break;

                case 11:
                    // Selectionsort
                    int[] selectionArray = leerArreglo();
                    selectionsort(selectionArray);
                    break;

                case 12:
                    // Quicksort
                    int[] quickArray = leerArreglo();
                    quicksort(quickArray, 0, quickArray.length - 1);
                    System.out.println("Arreglo ordenado: " + Arrays.toString(quickArray));
                    break;

                case 0:
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }

        } while (opcionAlgoritmo != 0);
    }

    private static int[] leerArreglo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de elementos: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Ingrese los elementos del arreglo:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    // Métodos de ordenamiento
    private static void bubblesort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // swap temp and arr[i]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                System.out.println(Arrays.toString(array));
            }
        }
    }

    private static void cocktailsort(int[] array) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i <= array.length - 2; i++) {
                if (array[i] > array[i + 1]) {
                    // swap
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
            swapped = false;
            for (int i = array.length - 2; i >= 0; i--) {
                if (array[i] > array[i + 1]) {
                    // swap
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
        System.out.println(Arrays.toString(array));
    }

    private static void insertionsort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
            System.out.println(Arrays.toString(array));
        }
    }

    private static void bucketsort(int[] array) {
        int maxVal = getMax(array);
        int[] bucket = new int[maxVal + 1];
        int[] sortedArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            bucket[array[i]]++;
        }

        int outPos = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                sortedArray[outPos++] = i;
            }
        }

        System.out.println(Arrays.toString(sortedArray));
    }

    private static int getMax(int[] array) {
        int max = array[0];
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    private static void countingsort(int[] array) {
        int max = getMax(array);
        int[] count = new int[max + 1];
        int[] output = new int[array.length];

        for (int value : array) {
            count[value]++;
        }

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        System.out.println(Arrays.toString(output));
    }

    private static void mergesort(int[] array, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            mergesort(array, l, m);
            mergesort(array, m + 1, r);

            merge(array, l, m, r);
        }
    }

    private static void merge(int[] array, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(array, l, L, 0, n1);
        System.arraycopy(array, m + 1, R, 0, n2);

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
        System.out.println(Arrays.toString(array));
    }

    /*private static void binarytreesort(int[] array) {
        BinaryTree tree = new BinaryTree();
        for (int value : array) {
            tree.insert(value);
        }
        tree.inorder();
    }*/

    private static void pigeonholesort(int[] array) {
        int min = Arrays.stream(array).min().orElse(0);
        int max = Arrays.stream(array).max().orElse(0);
        int range = max - min + 1;

        int[] pigeonhole = new int[range];
        Arrays.fill(pigeonhole, 0);

        for (int j : array) {
            pigeonhole[j - min]++;
        }

        int index = 0;
        for (int i = 0; i < range; i++) {
            while (pigeonhole[i]-- > 0) {
                array[index++] = i + min;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    private static void radixsort(int[] array) {
        int max = getMax(array);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortRadix(array, exp);
            System.out.println(Arrays.toString(array));
        }
    }

    private static void countingSortRadix(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        System.arraycopy(output, 0, array, 0, n);
    }

    private static void shellsort(int[] array) {
        int n = array.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
            System.out.println(Arrays.toString(array));
        }
    }

    private static void selectionsort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // swap
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
            System.out.println(Arrays.toString(array));
        }
    }

    private static void quicksort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            quicksort(array, low, pi - 1);
            quicksort(array, pi + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;

                // Mostrar la iteración actual
                System.out.println(Arrays.toString(array));
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        // Mostrar la iteración actual
        System.out.println(Arrays.toString(array));

        return i + 1;
    }

}
