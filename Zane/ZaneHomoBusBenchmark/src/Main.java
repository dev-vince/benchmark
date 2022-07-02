import io.github.nevalackin.homoBus.Listener;
import io.github.nevalackin.homoBus.annotations.EventLink;
import io.github.nevalackin.homoBus.bus.impl.EventBus;

import javax.swing.*;

public enum Main {
    INSTANCE;

    final EventBus<TestEvent> eventBus = new EventBus<>();

    public static void main(String[] args) {
        INSTANCE.eventBus.subscribe(INSTANCE);
        final long current = System.nanoTime();
        int iterations = 1000000;
        for (int i = 0; i < iterations; i++) {
            INSTANCE.eventBus.post(new TestEvent());
        }
        JOptionPane.showMessageDialog(null ,iterations + " iterations took " + ((System.nanoTime() - current) / 1000000.0) + "ms");
    }

    @EventLink
    public final Listener<TestEvent> testEventListener = e -> {
    };
}