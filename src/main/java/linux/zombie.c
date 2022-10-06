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