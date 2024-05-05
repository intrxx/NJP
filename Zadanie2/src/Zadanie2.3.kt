fun Zad3()
{
    val taskManager: TaskManagement = TaskManagement();
    val task: Task = Task("Zrob cos", "Proba zrobienia czegos", "19.04.2024", "21.04.2024");
    taskManager.addTask(task);
    taskManager.displayTasks();
    taskManager.removeTask(task);
    taskManager.displayTasks();

    var taskListToAdd = mutableListOf<Task>(
        Task("Zrob cos innego", "Proba zrobienia czegos innego", "20.04.2024", "22.04.2024"),
        Task("Zrob cos calkowicie innego", "Proba zrobienia czegos calkowicie innego", "23.04.2024", "25.04.2024"))

    taskManager.addListOfTasks(taskListToAdd);
    taskManager.displayTasks();
}

abstract class TaskComponent {
    open fun addTask(task: Task) {
    }

    open fun removeTask(task: Task) {
    }

    open fun displayTask() {
    }

    open fun addListOfTasks(taskList: MutableList<Task>){
    }
}

class Task(val name: String, val description: String, val startDate: String, val endDate: String) : TaskComponent() {
    override fun displayTask() {
        println("Zadanie: $name, Opis: $description, Data rozpoczecia: $startDate, Data zakonczenia: $endDate")
    }
}

class TaskList : TaskComponent() {
    private var taskList = mutableListOf<Task>()

    override fun addTask(task: Task) {
        this.taskList.add(task)
    }

    override fun addListOfTasks(taskList: MutableList<Task>) {
        taskList.forEach {
            this.taskList.add(it)
        }
    }

    override fun removeTask(task: Task) {
        taskList.remove(task)
    }

    override fun displayTask() {
        if(taskList.size == 0){
            println("Nie ma zadan do wyswietlenia")
        }
        taskList.forEach {
            println("Zadanie: ${it.name}, Opis: ${it.description}, Data rozpoczecia: ${it.startDate}, Data zakonczenia: ${it.endDate}")
        }
    }
}

class TaskManagement {
    private val taskList = TaskList()

    fun addTask(task: Task) {
        taskList.addTask(task)
    }

    fun removeTask(task: Task) {
        taskList.removeTask(task)
    }

    fun displayTasks() {
        taskList.displayTask()
    }

    fun addListOfTasks(taskListToCreate: MutableList<Task>) {
        taskList.addListOfTasks(taskListToCreate);
    }
}