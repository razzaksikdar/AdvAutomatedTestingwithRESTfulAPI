
public class Code {

	
	//Given n of 1 or more, return the factorial of n, which is n * (n-1) * (n-2) ... 1.
	//Compute the result recursively (without loops).
	public int factorial(int n) 
	{
		  
		  if(n==1)
		  {
		    return n;
		  }
		  
		  else 
		  {
		    return factorial(n-1) * n;
		  }
		}
	
	
	// We have a number of bunnies and each bunny has two big floppy ears. 
	//We want to compute the total number of ears across all the bunnies recursively (without loops or multiplication).
	
	public int bunnyEars(int bunnies) 
	{
		  
		  if(bunnies == 0 )
		  {
		    return 0;
		  }
		  
		  else 
		  {
			  return bunnyEars(bunnies-1) + 2;
		  }
		    
	  }
	
	// Given a non-negative int n, return the count of the occurrences of 7 as a digit, so for example 717 yields 2. 
	// (no loops). Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), 
	//while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
	public int count7(int n) {
		  
		 if(n==7)
		 {
		   return 1;
		 }
		 
		 else if (n<10)
		 {
		   return 0;
		 }
		 else
		 {
		   return count7(n%10) + count7(n/10);
		 }
		 
		}
	
	//fibonacci sequence
	public int fibonacci(int n) {
		  
		  
		  if (n==0)
		  {
		    return 0; 
		  }
		  
		  if(n==1)
		  {
		    return 1;
		  }
		  
		  else 
		  {
		    return fibonacci(n-1) + fibonacci(n-2);
		  }
		  
		}
	
	//BunnyEars2
	
	public int bunnyEars2(int bunnies) 
	{
	  
	  if (bunnies == 0)
	  {
	    return 0;
	  }
	  
	  else 
	  {
	    if (bunnies % 2 != 0)
	    {
	      return bunnyEars2(bunnies-1) + 2;
	    }
	    
	    return bunnyEars2(bunnies-1) + 3;
	    
	  }
	}
	
	//We have triangle made of blocks. The topmost row has 1 block, the next row down has 2 blocks, the next row has 3 blocks, and so on. 
	//Compute recursively (no loops or multiplication) the total number of blocks in such a triangle with the given number of rows.
	public int triangle(int rows) {
		  
		  if (rows==0)
		  {
		    return 0;
		  }
		  
		  return triangle(rows-1) + rows;
		  
		}


	//Given a non-negative int n, return the sum of its digits recursively (no loops). 
	//Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), 
	//while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
	public int sumDigits(int n) {
		  
		  if (n==0)
		  {
		    return 0; 
		  }
		  
		  return sumDigits(n/10) + (n%10);
		  
		}

	//count8
	public int count8(int n)
	{
	  
	  if (n == 0)
	  {
	    return 0;
	  }
	  
	  if (n%10 == 8)
	  {
	    
	    if ((n/10) % 10 ==8)
	    {
	      return 2 + count8(n/10);
	    }
	    
	    return 1 + count8(n/10);
	  }
	  
	  return count8(n/10);
	  
	}
	
	//powerBase 
	public int powerN(int base, int n) {
		  
		  if(n==1)
		  {
		    return base;
		  }
		  
		  return powerN(base, n -1)  * base;
		  
		}
	
	
	
}
