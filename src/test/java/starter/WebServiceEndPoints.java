package starter;

public enum WebServiceEndPoints {
    STATUS("https://developer.nytimes.com/");

    private final String url;

    WebServiceEndPoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
