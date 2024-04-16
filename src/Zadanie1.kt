object sTaskManager
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

fun zadanie1()
{
    println("\n Zadanie 1");
    
    sTaskManager.addTask("DoSomething");
    sTaskManager.addTask("DoNothing");
    
    sTaskManager.printAllTasks();
}