## What is a Zombie Process?
A <strong>zombie(defunct) process</strong> is a process that has completed execution but still has an entry in the <strong>process table</strong>. It is a process in a terminated state. It is also called a <strong>defunct process or a dead process</strong>.

![](https://github.com/Fas96/T-images-repo/blob/main/zombiess.png?raw=true)

A zombie process remains in the process table until its parent process reads its exit status using the wait() system call. If the parent process does not read the exit status, the zombie process remains in the process table forever. The zombie process is a process that has completed execution but still has an entry in the process table. It is a process in a terminated state. It is also called a defunct process or a dead process. A zombie process remains in the process table until its parent process reads its exit status using the wait() system call. If the parent process does not read the exit status, the zombie process remains in the process table forever.

## So what is a Process Table?
A process table is a data structure that contains information about all the processes that are currently running on the system(OS). 
It contains information such as 
1. process ID 
2. parent process ID 
3. process state 
4. priority
5. CPU registers 
6. memory usage, etc. 
7. Pointers to the executable machine code of a process.

The process table is maintained by the kernel.  

> A very important information in the process table is the state in that each process currently is. This information is essential for the OS, because it enables the so called multiprocessing, i.e. the possibility to virtually run several processes on only one processing unit (CPU).

The OS processes state ACTIVE, SLEEPING, RUNNING, etc. is used in order to handle the execution of processes.

 ![](https://i.stack.imgur.com/vnC4H.png)


## How to create a Zombie Process?
A zombie process is created when a <strong>child process</strong> completes its execution but its <strong>parent process</strong> does not read its exit status using the wait() system call. 
The child process remains in the process table until its parent process reads its exit status.
IF THE PARENT PROCESS DOES NOT read the exit status, the child process remains in the process table forever. 
The child process becomes a <strong>zombie(defunct)</strong> process.

![](https://github.com/Fas96/T-images-repo/blob/main/zombie.gif?raw=true)

```java
#include <stdio.h>
#include <unistd.h>


int main(int argc, char* argv[]){

	pid_t pid= fork();

 
	if(pid==0){
	puts("Hi Fas I am the child process");
	}else{

	printf("Child process Id: %d\n",pid);
	        sleep(30);
	}

	if(pid==0){
	  puts("END OF CHILD PROCESS");
	}else{
	  puts("END OF parent PROCESS");
	}

return 0;

}
```

## How to check if a process is a Zombie Process?
A zombie(defunct) process can be identified by the following command:
```bash
ps -l

# Output
F S   UID   PID  PPID  C PRI  NI ADDR SZ WCHAN  TTY          TIME CMD
4 S     0  1234  1233  0  80   0 -  1234 -      pts/0    00:00:00 bash
0 Z     0  1235  1234  0  80   0 -  1234 -      pts/0    00:00:00 sleep 100
```


## How to kill a Zombie Process?

### Method 1: kill

```bash
kill -9 <PID>

```

### Method 2: killall

```bash
killall -9 <process_name>

```

### Method 3: pkill

```bash
pkill -9 <process_name>

```

### Method 4: killall5

```bash
killall5 -9 <process_name>

```

## Key Takeaways
1. A zombie process is a process that has completed execution but still has an entry in the process table. It is a process in a terminated state. It is also called a defunct process or a dead process. A zombie process remains in the process table until its parent process reads its exit status using the wait() system call. If the parent process does not read the exit status, the zombie process remains in the process table forever.
2. A process table is a data structure that contains information about all the processes that are currently running on the system(OS). It contains information such as process ID, parent process ID, process state, priority, CPU registers, memory usage, etc. Pointers to the executable machine code of a process.
3. A zombie process is created when a child process completes its execution but its parent process does not read its exit status using the wait() system call. The child process remains in the process table until its parent process reads its exit status. IF THE PARENT PROCESS DOES NOT read the exit status, the child process remains in the process table forever. The child process becomes a zombie(defunct) process.
4. A zombie(defunct) process can be identified by the following command: ps -l

### References
1. [geeksforgeeks](https://www.geeksforgeeks.org/zombie-processes-and-how-to-avoid-them/)
2. [stackoverflow](stackoverflow.com/questions/11227809/why-is-it-called-a-zombie-process)
3. [tutorialspoint](https://www.tutorialspoint.com/what-is-zombie-process-in-linux)
4. [techopedia](https://www.techopedia.com/definition/18788/zombie-process)

