import java.util.Arrays;
import java.util.Objects;

public class IntegerArrayList implements IntegerList {

    private Integer[] items;

    public IntegerArrayList(int size) {
        if (size > 0) {
            this.items = new Integer[size];
        } else if (size == 0) {
            this.items = new Integer[0];
        } else {
            throw new IllegalArgumentException("Требуется указать размер коллекции больше и равным 0");
        }
    }

    public IntegerArrayList(Integer[] array) {
        if (array != null) {
            this.items = array;
        } else {
            throw new IllegalArgumentException("Требуется указать массив для передачи в коллекцию");
        }
    }

    private void checkInputIsNotNull(Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("Требуется ввести корректное значение");
        }
    }

    private void checkCorrectIndex(int index) {
        if (index > this.items.length - 1 || index < 0) {
            throw new IllegalArgumentException("Значение index за пределами размера коллекции");
        }
    }

    private void checkAndIncreaseListSize() {
        if (this.items[this.items.length - 1] != null) {
            this.items = Arrays.copyOf(this.items, this.items.length + 1);
        }
    }

    private void sort() {
        for (int i = 1; i < this.items.length; i++) {
            int temp = this.items[i];
            int j = i;
            while (j > 0 && this.items[j - 1] >= temp) {
                this.items[j] = this.items[j - 1];
                j--;
            }
            this.items[j] = temp;
        }
    }

    private boolean binarySearch(Integer item) {
        sort();
        int min = 0;
        int max = this.items.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (Objects.equals(item, this.items[mid])) {
                return true;
            }

            if (item < this.items[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    public Integer add(Integer item) {
        checkInputIsNotNull(item);
        checkAndIncreaseListSize();
        if (this.items[0] == null) {
            this.items[0] = item;
        } else {
            for (int i = 0; i < this.items.length; i++) {
                if (this.items[i] == null) {
                    this.items[i] = item;
                    break;
                }
            }
        }
        return item;
    }

    public Integer add(int index, Integer item) {
        checkInputIsNotNull(item);
        checkCorrectIndex(index);
        checkAndIncreaseListSize();
        for (int i = 0; i < this.items.length; i++) {
            if (i > index) {
                int j = i - 1;
                this.items[this.items.length - j] = this.items[this.items.length - i];
            }
        }
        this.items[index] = item;
        return item;
    }

    public Integer set(int index, Integer item) {
        checkInputIsNotNull(item);
        checkCorrectIndex(index);
        this.items[index] = item;
        return item;
    }

    public Integer remove(Integer item) {
        checkInputIsNotNull(item);
        if (!contains(item)) {
            throw new IllegalArgumentException("Элемент item = " + item + " не найден в коллекции");
        } else {
            for (int i = 0; i < this.items.length; i++) {
                if (this.items[i].equals(item)) {
                    this.items[i] = null;
                    for (int j = i; j < this.items.length - 1; j++) {
                        this.items[j] = this.items[j + 1];
                    }
                    this.items = Arrays.copyOf(this.items, this.items.length - 1);
                    break;
                }
            }
        }
        return item;
    }

    public Integer removeIdx(int index) {
        checkCorrectIndex(index);
        remove(this.items[index]);
        return items[index];
    }

    public boolean contains(Integer item) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(Integer item) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Integer item) {
        for (int i = this.items.length - 1; i >= 0; i--) {
            if (this.items[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public Integer get(int index) {
        checkCorrectIndex(index);
        for (int i = 0; i < this.items.length; i++) {
            if (i == index) {
                return this.items[i];
            }
        }
        return null;
    }

    public boolean equals(IntegerList otherList) {
        if (this == otherList) return true;
        if (otherList == null) {
            throw new IllegalArgumentException("Требуется ввести корректное значение");
        }
        IntegerArrayList that = (IntegerArrayList) otherList;
        return Arrays.equals(items, that.items);
    }

    public int size() {
        int count = 0;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null) {
                count++;
            }
        }
        return count;
    }

    public boolean isEmpty() {
        for (int i = 0; i < this.items.length; i++) {
            return this.items[i] == null;
        }
        return false;
    }

    public void clear() {
        for (int i = 0; i < this.items.length; i++) {
            this.items[i] = null;
        }
    }

    public Integer[] toArray() {
        Integer[] array = new Integer[this.items.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = this.items[i];
        }
        return array;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerArrayList that = (IntegerArrayList) o;
        return Arrays.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(items);
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
