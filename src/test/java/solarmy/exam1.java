package solarmy;

import java.util.ArrayList;

public class exam1 {
    public static void main(String[] args) {
        ArrayList<Integer> aa = new ArrayList<Integer>();

//        for (int i = 0; i < 10; i++) {
//            aa.add((int) (Math.random() * 10));
//        }

        for (int i = 0; i < 10; ) {
            int randomNum = (int)(Math.random() * 10);

            if (! aa.contains(randomNum)) {
                aa.add(randomNum);
                i++;
            }

            if (aa.size() == 10) break;
        }

        System.out.println(aa.toString());


        for (int i = 0; i < 10; i++) {
            System.out.println(aa.get(i));
        }
    }
}

