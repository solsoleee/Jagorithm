package collection.interable;

import java.util.Iterator;

public class MyArray implements Iterable<Integer>{


    private int[] numbers;
    public MyArray(int[] numbers){
        this.numbers = numbers;
    }

    //반복자를 반환
    // 생성자를 통해 MyArray의 내부 배열인 numbersckawh
    @Override
    public Iterator<Integer> iterator() {
        return new MyArrayIterator(numbers);
    }
}
