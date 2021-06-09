package Model;

import java.time.LocalDate;

public class Todo {

    private int todoId;
    private String title;
    private String description;
    private LocalDate deadline;
    private boolean done;
    private int assigneeId;

    public Todo( String title, String description, LocalDate deadline, boolean done, int assigneeId) {

        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.done = done;
        this.assigneeId = assigneeId;
    }

    public int getTodoId() {
        return todoId;
    }

    public int getAssigneeId() {
        return assigneeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
