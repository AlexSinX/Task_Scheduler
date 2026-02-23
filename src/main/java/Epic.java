import java.util.Arrays;

public class Epic extends Task {
    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    public String[] getSubtasks() {
        return subtasks;
    }

    @Override
    public boolean matches(String query) {
        // Защита от null
        if (query == null) {
            return false;
        }

        // Пустой запрос подходит всем задачам
        if (query.isEmpty()) {
            return true;
        }

        // Перебираем все подзадачи
        for (String subtask : subtasks) {
            if (subtask != null) {
                // Сравниваем без учета регистра
                if (subtask.toLowerCase().contains(query.toLowerCase())) {
                    return true;
                }
                // Также пробуем прямое сравнение на всякий случай
                if (subtask.contains(query)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Epic{id=" + getId() + ", subtasks=" + Arrays.toString(subtasks) + "}";
    }
}