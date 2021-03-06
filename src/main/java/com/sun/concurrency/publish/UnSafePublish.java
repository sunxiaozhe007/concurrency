package com.sun.concurrency.publish;

import com.sun.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;

/**
 * @program concurrency
 * @author: sunxiaozhe
 * @create: 2018/10/22 15:29
 */
@Slf4j
@NotThreadSafe
public class UnSafePublish {

    private String[] staters = {"a","b","c","d"};

    public String[] getStaters() {
        return staters;
    }

    public static void main(String[] args) {
        UnSafePublish unSafePublish = new UnSafePublish();
        log.info("{}", Arrays.toString(unSafePublish.getStaters()));

        unSafePublish.getStaters()[0] = "d";
        log.info("{}",Arrays.toString(unSafePublish.getStaters()));
    }
}
