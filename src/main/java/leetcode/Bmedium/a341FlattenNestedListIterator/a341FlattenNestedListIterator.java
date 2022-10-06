package leetcode.Bmedium.a341FlattenNestedListIterator;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import static org.hamcrest.MatcherAssert.assertThat;

public class a341FlattenNestedListIterator {
    public class NestedIterator implements Iterator<NestedInteger> {
        NestedInteger next;
        public NestedIterator(List<NestedInteger> nestedList) {
            next = nestedList.get(0);
        }
        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public NestedInteger next() {
            NestedInteger res = next;
            next = null;
            return res;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void forEachRemaining(Consumer<? super NestedInteger> action) {
            Iterator.super.forEachRemaining(action);
        }
    }


    public interface NestedInteger {
              public boolean isInteger();
              public NestedInteger getInteger();
              public List<NestedInteger> getList();
  }

}
