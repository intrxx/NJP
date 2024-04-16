object TaskManager
{
    private var Tasks = mutableMapOf<Int, String>();
    private var TaskNumber: Int = 0;
    var TaskName: String = "";

    fun addTask(taskName: String)
    {
        Tasks[TaskNumber] = taskName;
        TaskNumber++;
    }

    fun printAllTasks()
    {
        println(Tasks);
    }
}

fun Zadanie1()
{
    TaskManager.addTask("DoSomething");
    TaskManager.addTask("DoNothing");

    println("Zadanie 1");
    TaskManager.printAllTasks();
    println();
}