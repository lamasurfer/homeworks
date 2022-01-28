package org.example.task2;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.net.URI;
import java.time.LocalDate;

@JsonPropertyOrder({"copyright", "date", "explanation", "hdurl", "media_type", "service_version", "title", "url"})
public class NasaApod {

    private String copyright;
    private LocalDate date;
    private String explanation;
    private URI hdurl;
    @JsonProperty("media_type")
    private MediaType mediaType;
    @JsonProperty("service_version")
    private String serviceVersion;
    private String title;
    private URI url;

    public NasaApod() {
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public URI getHdurl() {
        return hdurl;
    }

    public void setHd_url(URI hd_url) {
        this.hdurl = hd_url;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public String getServiceVersion() {
        return serviceVersion;
    }

    public void setServiceVersion(String serviceVersion) {
        this.serviceVersion = serviceVersion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public URI getUrl() {
        return url;
    }

    public void setUrl(URI url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "NASAResponse{" +
                "copyright='" + copyright + '\'' +
                ", date=" + date +
                ", explanation='" + explanation + '\'' +
                ", hdurl='" + hdurl + '\'' +
                ", mediaType='" + mediaType + '\'' +
                ", serviceVersion='" + serviceVersion + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
