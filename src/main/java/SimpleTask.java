public class SimpleTask extends Task {
    protected String title;

    public SimpleTask(int id, String title) {
        super(id);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean matches(String query) {
        if (query == null) return false;
        if (query.isEmpty()) return true;

        return title != null &&
                (title.toLowerCase().contains(query.toLowerCase()) ||
                        title.contains(query));
    }

    @Override
    public String toString() {
        return "SimpleTask{id=" + getId() + ", title='" + title + "'}";
    }
}