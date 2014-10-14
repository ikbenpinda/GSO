package src;

/**
 * Created by Etienne on 14-10-2014.
 */
public class BannerController {

    private AEXBanner banner;
    private IEffectenBeurs effectenbeurs;

    public BannerController(AEXBanner banner, IEffectenBeurs effectenbeurs) {
        this.banner = banner;
        this.effectenbeurs = effectenbeurs;
    }
}
