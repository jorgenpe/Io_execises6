package Model;

import java.time.LocalDate;

public class Todo {

    private int todoId;
    private String title;
    private String description;
    private LocalDate deadline;
    private boolean done;
    private Person assignee;

    public Todo(int todoId, String title, String description, LocalDate deadline, boolean done, Person assignee) {
        this.todoId = todoId;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.done = done;
        this.assignee = assignee;
    }

    public Todo(String title, String description, LocalDate deadline, boolean done, Person assignee) {

        this.todoId = 0;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.done = done;
        this.assignee = assignee;
    }



    public Todo(int todoId, String title, String description, LocalDate deadline, boolean done) {
        this.todoId = todoId;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.done = done;
        this.assignee = null;
    }

    public Todo() {
    }

    public int getTodoId() {
        return todoId;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
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

    // Did something ugly. To handle toString I checked for null to handle assignee.
    @Override
    public String toString() {
        String assigneeString;
        if(assignee == null){
            assigneeString = "Null";
        }else
        {
            assigneeString = assignee.toString();
        }
        return "Todo{" +
                "todoId=" + todoId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", done=" + done +
                ", assigneeId=" + assigneeString +
                '}';
    }
}
