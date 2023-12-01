package solarmy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Random;

public class UniqueRandomNumbers {
    public static void main(String[] args) {
        Random rand = new Random();
        Set<Integer> set = new HashSet<Integer>();

        // Set의 크기가 10이 될 때까지 난수를 생성하여 추가
        while (set.size() < 10) {
            int number = rand.nextInt(10); // 0~9 사이의 난수 생성
            set.add(number); // Set에 난수 추가, 중복된 값은 자동으로 무시됨
        }

        // Set을 배열로 변환
        Integer[] result = set.toArray(new Integer[0]);
        System.out.println(Arrays.toString(result));
    }
}