data class Task(val name: String, val description: String, val status: String)

class TaskManager(private val tasks: List<Task> = listOf())
{
    fun getAllTasks(): List<Task>
    {
        return tasks;
    }

    fun addTask(name: String, description: String, status: String): TaskManager
    {
        val newTask = Task(name, description, status);
        return TaskManager(tasks + newTask);
    }

    fun removeTask(task: Task): TaskManager
    {
        return TaskManager(tasks.filterNot { it == task });
    }

    fun updateTaskStatus(task: Task, newStatus: String): TaskManager
    {
        val updatedTasks = tasks.map {
            if (it == task) {
                it.copy(status = newStatus);
            } else {
                it;
            }
        }
        return TaskManager(updatedTasks);
    }

}

fun zad2() {
    var taskManager = TaskManager();

    taskManager = taskManager.addTask("z1", "z1 desc", "TODO");
    taskManager = taskManager.addTask("z2", "z2 desc", "TODO");
    taskManager = taskManager.addTask("z3", "z3 desc", "DONE");

    val allTasks = taskManager.getAllTasks();
    println("All tasks: $allTasks:");
    
    val updatedTaskManager = taskManager.updateTaskStatus(allTasks.first(), "DONE");
    val updatedTaskManager2 = updatedTaskManager.removeTask(updatedTaskManager.getAllTasks().first());
    
    println("All tasks after updates: ${updatedTaskManager2.getAllTasks()}");

}