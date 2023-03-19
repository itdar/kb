package com.kb.common.utils;

import java.util.concurrent.ConcurrentSkipListMap;

public class CacheImplementation {

    public static ConcurrentSkipListMap<String, String> concurrentSkipListMap = new ConcurrentSkipListMap<>();

    public void cache(String key, String value) {
        if (concurrentSkipListMap.containsKey(key)) {

        }
        concurrentSkipListMap.put(key, value);
    }

}
