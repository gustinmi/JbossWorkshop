package i18n;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * 
 * One final thing to consider when using substitution constants is that it is safe to
 * change a constant in the I18N2 file without recompiling all of the classes that use the
 * constants. 
 * 
 * @author gustinm
 * @see Hardcore Java O'Reilly
 */
public final class I18N {

    private final static String BUNDLE_NAME = "oreilly/hcj/constants/I18N";

    private final static ResourceBundle BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    public static final String CANCEL;
    public static final String REFRESH;
    
    private I18N() {}

    static {
       CANCEL = getString(BUNDLE, "CANCEL");
       REFRESH = getString(BUNDLE, "REFRESH");
    }
   
    private static String getString(final ResourceBundle bundle, final String key) {
        try {
            return bundle.getString(key);
        }
        catch (final MissingResourceException ex) {
            assert (false) : ex.getMessage();
            return '!' + key + '!';
        }
    }
    
}