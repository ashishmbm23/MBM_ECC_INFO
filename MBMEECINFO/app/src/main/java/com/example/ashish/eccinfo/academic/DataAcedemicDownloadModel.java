package com.example.ashish.eccinfo.academic;

import java.io.Serializable;

/**
 * Created by Ashish on 8/20/2017.
 */

public class DataAcedemicDownloadModel implements Serializable {
    private String downloadText;
    private String downloadLink;

    public DataAcedemicDownloadModel() {
    }

    public String getDownloadText() {
        return downloadText;
    }

    public void setDownloadText(String downloadText) {
        this.downloadText = downloadText;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }

    public DataAcedemicDownloadModel(String downloadText, String downloadLink) {
        this.downloadText = downloadText;
        this.downloadLink = downloadLink;
    }

    @Override
    public String toString() {
        return this.getDownloadText();
    }
}
