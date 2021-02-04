public class Note {

    private String to;
    private String from;
    private String type;
    private String body;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "note{" +
                "\nto='" + to + '\'' +
                ", \nfrom='" + from + '\'' +
                ", \ntype='" + type + '\'' +
                ", \nbody='" + body + '\'' +
                '}';
    }
}
