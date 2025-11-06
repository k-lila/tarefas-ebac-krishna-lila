package tests;

import hashmap.HashMap;

public class HashMapTest {

    private HashMap hashMap;

    public HashMapTest() {
        this.hashMap = new HashMap();
    }

    public void test() throws Exception {
        System.out.println("put");
        for (int i = 0; i < 10; i++) {
            hashMap.put(i, i * i);
        }
        System.out.println(hashMap);
        System.out.println("######");
        System.out.println("delete");
        for (int i = 0; i < 5; i++) {
            hashMap.delete(i);
        }
        System.out.println(hashMap);
        System.out.println("######");
        System.out.println("put");
        for (int i = 30; i < 50; i++) {
            hashMap.put(i, i * i);
        }
        System.out.println(hashMap);
        System.out.println("######");
        System.out.println("get");
        int key = 33;
        Integer value = hashMap.get(key);
        System.out.println("key " + key + ": " + value);
        System.out.println("######");
        System.out.println("clear");
        hashMap.clear();
        System.out.println(hashMap);
    }


}
