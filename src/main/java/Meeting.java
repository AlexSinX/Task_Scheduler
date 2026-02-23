public class Meeting extends Task {
    protected String topic;
    protected String project;
    protected String start;

    public Meeting(int id, String topic, String project, String start) {
        super(id);
        this.topic = topic;
        this.project = project;
        this.start = start;
    }

    public String getTopic() {
        return topic;
    }

    public String getProject() {
        return project;
    }

    public String getStart() {
        return start;
    }

    @Override
    public boolean matches(String query) {
        if (query == null) return false;
        if (query.isEmpty()) return true;

        String lowerQuery = query.toLowerCase();

        boolean topicMatches = topic != null &&
                (topic.toLowerCase().contains(lowerQuery) ||
                        topic.contains(query));
        boolean projectMatches = project != null &&
                (project.toLowerCase().contains(lowerQuery) ||
                        project.contains(query));

        return topicMatches || projectMatches;
    }

    @Override
    public String toString() {
        return "Meeting{id=" + getId() + ", topic='" + topic + "', project='" + project + "'}";
    }
}