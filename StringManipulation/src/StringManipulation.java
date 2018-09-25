
public class StringManipulation {
	
	
	// String Manipulation
	
//	String nameOfString = "Hello Everybody"; 
//
//	System.out.println(nameOfString.substring(3)); // this goes from index 3 to the end
//	System.out.println(nameOfString.substring(0, 4)); // this has start and end point 
//	System.out.println(nameOfString.charAt(4)); // gets the char at index 4
//	// HELLO WORLD
//	System.out.println(nameOfString.trim().substring(nameOfString.length() -4, nameOfString.length() -2));
	public void section(String names)
	{
		
		System.out.println(names.substring(4));
	}
	
	public void backwards(String name)
	{
		// String [] list = name.split((" "); 
		
		// String [] list = name.split(""); 
		
		for(int i = name.length() - 1 ; i  >= 0; i--)
		{
			System.out.print(name.charAt(i));
		}
	}
	
	public void middle(String namess)
	{
		System.out.println();
		System.out.println(namess.substring(4, 9));
		
	}
	
	public void bert(String name)
	{
		int start = name.indexOf("bert");
		int end = name.lastIndexOf("bert");
		
		
		System.out.println(name.substring(start + 4, end));
		
	}
	
	
	// String Recursion
	public int countX(String str) 
	{
	  
	  if(str.length() == 0)
	  {
	    return 0;
	  }
	  
	  if(str.charAt(0) == 'x')
	  {
	    return 1 + countX(str.substring(1));
	    
	  }
	  return countX(str.substring(1));
	  
	}
	
	// countHI
	public int countHi(String str) {
		  
		  if(str.length() <= 1)
		  {
		    return 0;  
		  }
		  
		  if(str.indexOf("hi") == 0)
		  {
		      return 1 + countHi(str.substring(2));
		  }
		  
		  return countHi(str.substring(1)); 
		  
		}
	
	//replace x and y 
	public String changeXY(String str) {
		  
		  if (str.length() == 0)
		  {
		    return str;
		  }
		  
		  if (str.length() == 1)
		  {
		    if (str.equals("x"))
		  {
		    return "y";
		  }
		  return str; 
		  }
		  
		  
		  if (str.indexOf("x") == 0)
		  {
		    return "y" + changeXY(str.substring(1));
		  }
		  
		  return str.substring(0,1) + changeXY(str.substring(1));
		}

	//PI
	public String changePi(String str) {
		  
		  if(str.length() < 2)
		  {
		    return str;
		  }
		  
		  if(str.indexOf("pi") == 0)
		  {
		    return "3.14" + changePi(str.substring(2));
		  }
		  
		  return str.substring(0,1) + changePi(str.substring(1));
		  
		}
	
	//remove chars 
	public String noX(String str) {
		  
		  if(str.length() <= 0)
		  {
		    return str;
		  }
		  
		  if(str.indexOf("x") == 0)
		  {
		    return noX(str.substring(1));
		  }
		  
		  return str.substring(0,1) + noX(str.substring(1));
		}

	//array
	public boolean array6(int[] nums, int index) {
		  
		  if (index >= nums.length)
		  {
		    return false;
		  }
		  
		  if(nums[index] == 6)
		  {
		    return true;
		  }
		  
		  return array6(nums, index + 1);
		}
	
	//pairSTar
	public String pairStar(String str) {
		  
		  if(str.length() < 2)
		  {
		    return str;
		  }
		  
		  if (str.charAt(0) == str.charAt(1))
		  {
		    return str.charAt(0) + "*" +  pairStar(str.substring(1));
		  }
		  
		  return str.charAt(0) + pairStar(str.substring(1));
		}

	// putting a character at the end
	public String endX(String str) {
		  
		  if(str.length() == 0)
		  {
		    return "";
		  }
		  
		  if(str.charAt(0) == 'x')
		  {
		  return endX(str.substring(1)) + 'x';  
		  }
		  
		  else
		  {
		    return str.charAt(0) + endX(str.substring(1));
		  }
		  
		}
	
	//count
	public int countAbc(String str) {
		  
		  if(str.length() == 0)
		  {
		    return 0;
		  }
		  
		  if(str.indexOf("abc") == 0 || str.indexOf("aba") == 0)
		  {
		    return 1 + countAbc(str.substring(2));
		  }

		  
		  return countAbc(str.substring(1));
		  
		}

	//
	public int count11(String str) {
		  
		  if(str.length() <= 1)
		  {
		    return 0;
		  }
		  
		  if(str.charAt(0) == '1' && str.charAt(1) == '1')
		  {
		    return 1 + count11(str.substring(2));
		  }
		  
		  return count11(str.substring(1));
		}

}
