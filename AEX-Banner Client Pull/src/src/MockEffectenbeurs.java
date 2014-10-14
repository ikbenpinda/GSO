package src;

/**
 * Created by Etienne on 14-10-2014.
 */
public class MockEffectenbeurs implements IEffectenBeurs {

    /**
     *
     * @return
     */
    @Override
    public IFonds[] getKoersen() {
        return new IFonds[0];
    }
}
