package be.bornput.lists;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class LoopUtil {

    static <T> void  forEachWithCounter (Iterable <T> source , BiConsumer<Integer, T> consumer){
       int cntr = 0;
       for( T item : source)
        consumer.accept(cntr++, item);
    }

    static <T> Consumer<T> withCounter(BiConsumer<Integer, T> consumer){
        AtomicInteger cntr = new AtomicInteger(0);
        return item -> consumer.accept(cntr.getAndIncrement(), item);
    }

}
