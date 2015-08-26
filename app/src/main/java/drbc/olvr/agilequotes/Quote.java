package drbc.olvr.agilequotes;

import java.net.URL;

/**
 * Created by WAlly on 17/févr./2015.
 */
public class Quote {
    private Integer mID;
    private String mQuote;
    private String mAuthor;
    private String mSource;
    private String mLink;

    public Quote(Integer _id, String _quote, String _author, String _source, String _link) {
        this.mID = _id;
        this.mQuote = _quote;
        this.mAuthor = _author;
        this.mSource = _source;
        this.mLink = _link;
    }

    public Integer getID() {
        return mID;
    }

    public String getQuote() {
        return mQuote;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getSource() {
        return mSource;
    }

    public String getLink() {
        return mLink;
    }

    @Override
    public String toString() {
        StringBuffer _s = new StringBuffer();
        _s.append("<ID=").append(mID);
        _s.append(", Quote=").append(mQuote);
        _s.append(", Author=").append(mAuthor);
        _s.append(", Source=").append(mSource);
        _s.append(", Link=").append(mLink).append(">");
        return _s.toString();
    }
}
