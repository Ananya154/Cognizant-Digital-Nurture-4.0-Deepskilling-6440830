package taskmanager_5;

public class Task {
    public int taskId;
    public String taskName;
    public String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public String toString() {
        return "ID: " + taskId + ", Task: " + taskName + ", Status: " + status;
    }
}
