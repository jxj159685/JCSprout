package com.crossoverjie.generic;

import java.util.*;

public class Countries {
    public static final String[][] DATA = {{"中国", "北京"}, {"俄罗斯", "莫斯科"}};

    private static class FlyweightMap extends AbstractMap<String, String> {

        private Set<Map.Entry<String, String>> entries = new EntrySet(DATA.length);

        @Override
        public Set<Map.Entry<String, String>> entrySet() {
            return entries;
        }

        private static class Entry
                implements Map.Entry<String, String> {

            private int index;

            public Entry(int index) {
                this.index = index;
            }

            @Override
            public String getKey() {
                return DATA[index][0];
            }

            @Override
            public String getValue() {
                return DATA[index][1];
            }

            @Override
            public String setValue(String value) {
                return null;
            }

            @Override
            public int hashCode() {
                return DATA[index][0].hashCode();
            }
        }

        static class EntrySet extends AbstractSet<Map.Entry<String, String>> {

            private int size;

            public EntrySet(int size) {
                this.size = size;
            }

            @Override
            public Iterator<Map.Entry<String, String>> iterator() {
                return new Iter();
            }

            @Override
            public int size() {
                return size;
            }

            private class Iter implements Iterator<Map.Entry<String, String>> {
                private Entry entry = new Entry(-1);

                @Override

                public boolean hasNext() {
                    return entry.index < size - 1;
                }

                @Override
                public Map.Entry<String, String> next() {
                    entry.index++;
                    return entry;
                }
            }
        }


    }

    static Map<String, String> select(int size) {
        return new FlyweightMap() {
            @Override
            public Set<Map.Entry<String, String>> entrySet() {
                return new EntrySet(size);
            }
        };
    }

    static Map<String, String> map = new FlyweightMap();

    static Map<String, String> capitals(int s) {
        return select(s);
    }


    public static void main(String[] args) {
        System.out.println(capitals(2));
        System.out.println(new HashMap<String, String>(capitals(2)));
    }


}
