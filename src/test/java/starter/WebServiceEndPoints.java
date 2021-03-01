package starter;

public enum WebServiceEndPoints {
    STATUS("https://jsonplaceholder.typicode.com/todos/1");

    private final String url;

    WebServiceEndPoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
