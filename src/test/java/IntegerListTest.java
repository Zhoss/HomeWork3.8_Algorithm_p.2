import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IntegerListTest {

    @Test
    void addInteger() {
        IntegerList expected = new IntegerArrayList(new Integer[]{1, 2, 3, 4, 5});

        IntegerList actual = new IntegerArrayList(3);
        actual.add(1);
        actual.add(2);
        actual.add(3);
        actual.add(4);
        actual.add(5);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void addingIncorrectInputTrowsIllegalArgumentException() {
        IntegerList actual = new IntegerArrayList(3);

        Assertions.assertThrows(IllegalArgumentException.class, () -> actual.add(null));
    }

    @Test
    void addIntegerToPosition() {
        IntegerList expected = new IntegerArrayList(new Integer[]{1, 2, 3, 4, 5});

        IntegerList actual = new IntegerArrayList(new Integer[]{1, 3, 4, 5});

        actual.add(1, 2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void enterIncorrectIndexTrowsIllegalArgumentException() {
        IntegerList actual = new IntegerArrayList(3);

        Assertions.assertThrows(IllegalArgumentException.class, () -> actual.add(5, 777));
        Assertions.assertThrows(IllegalArgumentException.class, () -> actual.add(-11, 777));
    }

    @Test
    void setNewValue() {
        IntegerList expected = new IntegerArrayList(new Integer[]{1, 2, 3, 4, 5});

        IntegerList actual = new IntegerArrayList(new Integer[]{1, 3, 3, 4, 5});
        actual.set(1, 2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void removeInteger() {
        IntegerList expected = new IntegerArrayList(new Integer[]{1, 2, 3, 5});

        IntegerList actual = new IntegerArrayList(new Integer[]{1, 2, 3, 4, 5});
        actual.remove(4);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void removeIntegerFromPosition() {
        IntegerList expected = new IntegerArrayList(new Integer[]{1, 2, 3, 5});

        IntegerList actual = new IntegerArrayList(new Integer[]{1, 2, 3, 4, 5});
        actual.removeIdx(3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void removingIncorrectInputTrowsIllegalArgumentException() {
        IntegerList actual = new IntegerArrayList(new Integer[]{1, 2, 3, 4, 5});

        Assertions.assertThrows(IllegalArgumentException.class, () -> actual.remove(777));
    }

    @Test
    void containsInteger() {
        IntegerList actual = new IntegerArrayList(new Integer[]{1, 2, 3, 4, 5});

        Assertions.assertTrue(actual.contains(3));
        Assertions.assertFalse(actual.contains(8));
    }

    @Test
    void indexOfInteger() {
        int expected = 0;
        IntegerList actual = new IntegerArrayList(new Integer[]{4, 2, 3, 4, 5});

        Assertions.assertEquals(expected, actual.indexOf(4));
        Assertions.assertEquals(-1, actual.indexOf(9));
    }

    @Test
    void lastIndexOfInteger() {
        int expected = 3;
        IntegerList actual = new IntegerArrayList(new Integer[]{4, 2, 3, 4, 5});

        Assertions.assertEquals(expected, actual.lastIndexOf(4));
        Assertions.assertEquals(-1, actual.indexOf(9));
    }

    @Test
    void getInteger() {
        Integer expected = 5;
        IntegerList actual = new IntegerArrayList(new Integer[]{1, 2, 3, 4, 5});

        Assertions.assertEquals(expected, actual.get(4));
    }

    @Test
    void ListEqualsList() {
        IntegerList expected = new IntegerArrayList(new Integer[]{1, 2, 3, 4, 5});
        IntegerList anotherExpected = new IntegerArrayList(new Integer[]{1, 2, 3, 5});

        IntegerList actual = new IntegerArrayList(new Integer[]{1, 2, 3, 4, 5});

        Assertions.assertEquals(expected, actual);
        Assertions.assertNotEquals(anotherExpected, actual);
    }

    @Test
    void comparisonListWithNullTrowsIllegalArgumentException() {
        IntegerList actual = new IntegerArrayList(new Integer[]{1, 2, 3, 4, 5});
        IntegerList nullList = null;

        Assertions.assertThrows(IllegalArgumentException.class, () -> actual.equals(nullList));
    }

    @Test
    void sizeOfList() {
        int expected = 2;
        IntegerList actual = new IntegerArrayList(new Integer[]{1, 4, null});

        Assertions.assertEquals(expected, actual.size());
    }

    @Test
    void ListIsEmpty() {
        IntegerList actual = new IntegerArrayList(new Integer[]{1, 4, 5});
        IntegerList anotherActual = new IntegerArrayList(new Integer[]{null, null, null});

        Assertions.assertFalse(actual.isEmpty());
        Assertions.assertTrue(anotherActual.isEmpty());
    }

    @Test
    void clearList() {
        IntegerList expected = new IntegerArrayList(new Integer[]{null, null, null});
        IntegerList actual = new IntegerArrayList(new Integer[]{1, 4, 5});
        actual.clear();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void ListToArray() {
        Integer[] expected = {1, 2, 3, 4, 5};
        IntegerList actual = new IntegerArrayList(5);
        actual.add(1);
        actual.add(2);
        actual.add(3);
        actual.add(4);
        actual.add(5);

        Assertions.assertArrayEquals(expected, actual.toArray());
    }
}