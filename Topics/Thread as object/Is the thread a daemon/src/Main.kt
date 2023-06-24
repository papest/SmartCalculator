fun printIfDaemon(thread: Thread) = println(
    if (thread.isDaemon) "" else {
        "not "
    } + "daemon"
)
