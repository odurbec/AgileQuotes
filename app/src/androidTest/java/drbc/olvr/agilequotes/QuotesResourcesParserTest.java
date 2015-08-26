package drbc.olvr.agilequotes;

import android.content.res.Resources;
import android.test.InstrumentationTestCase;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author Cyril Mottier
 */
public final class QuotesResourcesParserTest extends InstrumentationTestCase {

    private Resources mResources;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        mResources = getInstrumentation().getContext().getResources();
    }

    public void testDefaultRoot() {
        List list = QuotesResourcesParser.getQuotesResources(mResources, R.xml.res_xml_quotes);

        assertEquals(4, list.size());
    }
}
