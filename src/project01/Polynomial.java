package project01;

import java.util.Arrays;

class Polynomial {

	 double [] data;

	Polynomial(double [] arr){

		data = Arrays.copyOf(arr,arr.length);
	}
	
	Polynomial(){
		
	}

	Polynomial(Polynomial obj){

		for(int i = 0 ; i < obj.data.length; i++) {

			this.data[i] = obj.data[i];
		}
	}

	public void set(double [] a) {

		for(int i = 0 ; i < a.length ;i++) {
			data[i] = a[i];
		}
	}

	public double[] get() {

		return data;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		int length = data.length;
		String str ;
		double num;
		boolean flag = false;
		if( length < 0) {
			builder.append(0);
		}
		if(length <= 0) {
			num = data[0];
			builder.append(num);
		}
		if(length <= 1) {
			num = data[1];
	         if(num == 1) {
	        	 str = "X";
	         }else {
	        	 str = num + "X";
	         }
	         builder.append(str);
		}
		if(length >= 2) {
			
			for(int i = 0 ; i <= data.length -1 - 2 ;i++) {
				
				
				num = data[i];
				if(i==0&& num > 0 && !flag) {
					str = (num==1)?( "X^" + (data.length-1-i)):(  num + "X^" + (data.length-1-i));
					builder.append(str);
					flag = false;
				}
				else if(num > 0 && !flag) {
					str = (num==1)?(" + "+ "X^" + (data.length-1-i)):(" + " + num + "X^" + (data.length-1-i));
					builder.append(str);
					flag = false;
				}else if(num > 0 && flag) {
					str = (num==1)?("X^" + (data.length-1-i)):( num + "X^" + (data.length-1-i));
					builder.append(str);
					flag = false;
				}
				else if( num < 0){
					str = (num == -1)?("-"+"X^" + (data.length-1-i)):(num + "X^" + (data.length-1-i));
					builder.append(str);
					flag = false;
				}else if(num == 0){
					str = "";
					builder.append(str);
					flag = true;
				}
			}
			num = data[data.length-2];
	         if(num == 1) {
	        	 str = " + " + "X";
	        	 builder.append(str);
	         }else if(num == 0) {
	        	 str = "";
	        	 builder.append(str);
	         }else if( num < 0){
	        	 str = num + "X";
	        	 builder.append(str);
	         }else {
	        	 str = " + " + num+"X" ;
	        	 builder.append(str);
	         }
	        
	         num = data[data.length-1];
	        
	         if(num > 0) {
	        	 str = " + " + num;
	        	 builder.append(str);
	         }else if( num == 0){
	        	 str = "";
	        	 builder.append(str);
	         }else if(num < 0) {
	        	 str = " "+num;
	        	 builder.append(str);
	         }
			
		}
		
		return builder.toString();
	}

   public double f(double num) {
	   
	   double [] arr = data;
	   double sum = 0.0;
	   for(int i = 0 ; i < arr.length ;i++) {
		   
		   sum+= (arr[i]*Math.pow(num, arr.length-1-i));
		   
	   }
	   
	   return sum;
   }     
   
   public static Polynomial add(Polynomial lhs, Polynomial rhs) {
	   
	   int len1 = lhs.data.length;
	   int len2 = rhs.data.length;
	  Polynomial min = (len1 <= len2)?(lhs):(rhs);
	  Polynomial max = (len1>=len2)?(lhs):(rhs);
	  int dis = max.data.length - min.data.length;
	  double [] array = new double[max.data.length];
	   int index = array.length-1;
	  for(int i = min.data.length-1 ; i >= 0 ; i--) {
		  
		  array[index]= min.data[i]+max.data[i + dis];
		  index--;
	  }
	   
	  for(int i = index ; i >= 0 ; i-- ) {
		  array[i] = max.data[i];
	  }
	   return new Polynomial(array);
	   
	   
   }
	

}
