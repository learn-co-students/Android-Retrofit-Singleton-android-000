package com.flatiron.beats.net.responses;

public class Base<T> {
    public T[] data;

    public Info info;
    public class Info {
        public int offset;
        public int count;
        public int total;
    }

    public String code;
}
