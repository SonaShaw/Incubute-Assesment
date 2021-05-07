package com.incubyte;



public class StringCalculator {
	private String numbers;
	
	public StringCalculator(String numbers){
		this.numbers = numbers;	
	}
	
	public StringCalculator() {}

	
	
	int Add(String numbers) {
		
		if(numbers.length()==0)
			return 0;
		if(numbers.length()==1) {
			int n = Integer.parseInt(numbers);
			return n;
		}else {
			String delimeter = ",";
			String actualNumbers = "";
			
			if(numbers.substring(0,2).equals("//")) {
				delimeter = numbers.charAt(2)+"";
				actualNumbers = numbers.substring(3, numbers.length());	
			}else {
				actualNumbers=numbers;
			}
			
			String num = actualNumbers.replace("\n", delimeter);
			String s[] = num.split(delimeter+"|\\,");
			int sum = 0;
			try {
				boolean isNegativeValue = false;
				String negativeValues = "";
				for(String x:s) {
					if(!x.equals("")) {
						int val = Integer.parseInt(x);
						if(val<0) {
							if(!isNegativeValue)
								isNegativeValue = true;
							negativeValues = negativeValues+val+" ";
						}
						if(val<=1000)
							sum = sum + val;
					}	
				}
				if(isNegativeValue)
					throw new Exception("negatives not allowed: "+negativeValues);
					
			} catch (Exception e) {
				e.printStackTrace();
				return -1;
			}
			return sum;	
		}
	}
}
