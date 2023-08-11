package com.omkardhage4535.math_master;


import java.util.Random;

public class helper_class {
    addition_act ac = new addition_act();

    public static int random_on(int n) {
        Random r = new Random();
        int no;
        no = r.nextInt(n);
        return no;
    }

    public static boolean help_check(int ans, int ur_ans) {
        return ans == ur_ans;
    }

    public boolean isgameover() {
        return ac.act_lives <= 0;
    }
}

