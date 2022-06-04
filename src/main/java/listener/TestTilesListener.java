package listener;

import org.apache.tiles.TilesApplicationContext;
import org.apache.tiles.factory.AbstractTilesContainerFactory;
import org.apache.tiles.startup.AbstractTilesInitializer;
import org.apache.tiles.startup.TilesInitializer;
import org.apache.tiles.web.startup.AbstractTilesListener;

public class TestTilesListener extends AbstractTilesListener {

    @Override
    protected TilesInitializer createTilesInitializer() {
        return new TestTilesListenerInitializer();
    }

    private static class TestTilesListenerInitializer extends AbstractTilesInitializer {

        @Override
        protected AbstractTilesContainerFactory createContainerFactory(
                TilesApplicationContext context) {
            return new TestTilesContainerFactory();
        }
    }
}