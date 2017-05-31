package su.levenetc.playground.java.datastructures;

import java.util.Iterator;

import su.levenetc.playground.java.utils.Out;

/**
 * Created by eugene.levenetc on 31/05/2017.
 * Stores values from 0 to 31
 */
public class BitSet {

    int data = 0;

    public void add(int value) {
        data |= 1 << value;
    }

    public boolean contains(int value) {
        int tmp = 0;
        tmp |= 1 << value;
        return (data & tmp) == tmp;
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            int index = 0;

            @Override
            public boolean hasNext() {
                setIndex();
                if (index <= 31) return true;
                else return false;
            }

            @Override
            public Integer next() {
                int result = index;
                index++;
                return result;
            }

            void setIndex() {
                for (int i = index; i < 31; i++) {
                    if ((data & (1 << i)) > 0) {
                        index = i;
                        return;
                    }
                }
                index = 32;
            }
        };
    }

    @Override
    public String toString() {
        return Out.binValue(data);
    }
}
