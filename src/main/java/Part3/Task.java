package Part3;

import java.time.LocalDate;

public class Task {
    private String owner;
    private String description;
    private LocalDate deadline;

    public Task(String owner, String description, LocalDate deadline) {
        this.owner = owner;
        this.description = description;
        if (deadline.isBefore(LocalDate.now()) || deadline.isEqual(LocalDate.now())){
            throw new IllegalArgumentException();
        }
        else {
            this.deadline = deadline;
        }

    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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
        if (deadline.isBefore(LocalDate.now()) || deadline.isEqual(LocalDate.now())){
            throw new IllegalArgumentException();
        }
        else{
            this.deadline = deadline;
        }

    }
}
