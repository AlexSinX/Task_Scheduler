import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWhenFewTasksMatch() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить молоко");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search("Молоко");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWhenNoTasksMatch() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить молоко");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Отпуск");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWhenAllTasksMatch() {
        SimpleTask simpleTask = new SimpleTask(5, "Проект НетоБанка");

        String[] subtasks = {"Молоко", "Проект", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Проектная встреча",
                "НетоБанк",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("Проект");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWithEmptyQuery() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить молоко");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddAndFindAllWithEmptyTodos() {
        Todos todos = new Todos();

        Task[] expected = {};
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWithEmptyTodos() {
        Todos todos = new Todos();

        Task[] expected = {};
        Task[] actual = todos.search("Молоко");

        Assertions.assertArrayEquals(expected, actual);
    }

}