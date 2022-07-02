import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import javax.swing.*;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public enum Main {
    INSTANCE;

    final EventBus eventBus = new AsyncEventBus(new ThreadPoolExecutor(8, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>()));

    public static void main(String[] args) {
        INSTANCE.eventBus.register(INSTANCE);
        final long current = System.nanoTime();
        int iterations = 1000000;
        for (int i = 0; i < iterations; i++) {
            INSTANCE.eventBus.post(new TestEvent());
        }
        JOptionPane.showMessageDialog(null, iterations + " iterations took " + ((System.nanoTime() - current) / 1000000.0) + "ms");
    }

    @Subscribe
    public void testEventListener(TestEvent e) {
    }
}