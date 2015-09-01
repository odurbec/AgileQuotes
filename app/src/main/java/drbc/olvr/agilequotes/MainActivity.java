package drbc.olvr.agilequotes;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;


public class MainActivity extends ActionBarActivity {
    private static final String TAG = "MainActivity";
    private static HashMap<Integer, Quote> mQuoteList;

    TextView textQuote;
    TextView textAuthor;
    TextView textSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Crashlytics
        Fabric.with(this, new Crashlytics());

        setContentView(R.layout.activity_main);

        mQuoteList = QuotesResourcesParser.getQuotesResources(this.getResources(), R.xml.res_xml_quotes);

        textQuote = (TextView) findViewById(R.id.quote);
        textAuthor = (TextView) findViewById(R.id.author);
        textSource = (TextView) findViewById(R.id.source);


        Quote quote = mQuoteList.get(4);
        textQuote.setText(quote.getQuote());
        textAuthor.setText(quote.getAuthor());
        textSource.setText(quote.getSource());

        // Test for Crashlytics
        //throw new RuntimeException("This is a crash");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
