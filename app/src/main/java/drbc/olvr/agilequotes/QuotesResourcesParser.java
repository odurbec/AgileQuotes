package drbc.olvr.agilequotes;

/**
 * Created by WAlly on 17/févr./2015.
 */
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.util.HashMap;

/**
 * @author OlvrDrbc
 */
public final class QuotesResourcesParser {
    private static final String TAG = "QuotesResourcesParser";

    public static final String TAG_ROOT = "quotes";
    public static final String ATTR_VERSION = "version";
    public static final String TAG_QUOTE = "quote";
    public static final String ATTR_ID = "id";
    public static final String ATTR_CONTENT = "content";
    public static final String ATTR_AUTHOR = "author";
    public static final String ATTR_SOURCE = "source";
    public static final String ATTR_LINK = "link";

    private QuotesResourcesParser() {
        // No instance
    }

    public static HashMap getQuotesResources(Resources res, int resId) throws Resources.NotFoundException {
        return getQuotesResources(res, TAG_ROOT, resId);
    }

    public static HashMap getQuotesResources(Resources res, String rootTag, int resId) throws Resources.NotFoundException {
        XmlResourceParser parser = res.getXml(resId);

        HashMap listOfQuotes = new HashMap<Integer, Quote>();
        try {
            while (parser.next() != XmlPullParser.END_DOCUMENT) {
                if (parser.getEventType() != XmlPullParser.START_TAG) {
                    continue;
                }
                String name = parser.getName();

                // Starts by looking for the quote tag
                if (name.equals(TAG_QUOTE)) {
                    Quote _quote = readQuote(parser);
                    listOfQuotes.put(_quote.getID(), _quote);

                } else if (name.equals(TAG_ROOT)) {
                    checkVersion(parser);
                }
            }

            return listOfQuotes;

        } catch (Exception e) {
            final Resources.NotFoundException nfe = new Resources.NotFoundException();
            nfe.initCause(e);
            throw nfe;
        }
    }

    private static Quote readQuote(XmlPullParser parser) throws XmlPullParserException {
        String _id = parser.getAttributeValue(null, ATTR_ID);
        String _content = parser.getAttributeValue(null, ATTR_CONTENT);
        String _author = parser.getAttributeValue(null, ATTR_AUTHOR);
        String _source = parser.getAttributeValue(null, ATTR_SOURCE);
        String _link = parser.getAttributeValue(null, ATTR_LINK);

        Quote _quote = new Quote(Integer.parseInt(_id), _content, _author, _source, _link);
        //Log.v(TAG, "Quote="+ _quote.toString());

        return _quote;
    }

    private static void checkVersion(XmlPullParser parser) {
        String _version = parser.getAttributeValue(null, ATTR_VERSION);
    }
}