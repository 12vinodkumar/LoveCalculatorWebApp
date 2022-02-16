package com.example.lc.service;

import javax.validation.groups.Default;

import org.springframework.stereotype.Service;

@Service
public class LCAppServiceImpl implements ILCAppService {

	@Override
	public String calculateLove(String userName, String CrushName) {
		String result;
		System.out.println("CalculateLove userName received "+userName+" length : "+userName.length());
		System.out.println("CalculateLove crushName received "+CrushName+" length : "+CrushName.length());
		int calculated_length = getActualLengthtoCalculate(userName, CrushName);
		System.out.println("CalculateLove Calculatedlength : "+calculated_length);
		result = whatBetweenUs(calculated_length);
		return result;
	}

	private String whatBetweenUs(int calculated_length) {
		int result = calculate(calculated_length);
		String relationShip;
		
		switch(result)
		{
			case 1: relationShip = "FRIENDSHIP";
			break;
			case 2: relationShip = "LOVE";
			break;
			case 3: relationShip = "ATTRACTION";
			break;
			case 4: relationShip = "MARRAIGE";
			break;
			case 5: relationShip = "ENEMY";
			break;
			case 6: relationShip = "SISTER";
			break;
			default: relationShip = "FRIENDSHIP";
			break;
		}
		
		return relationShip;
        }
    private int calculate(int calculated_length) {
        	int n = -1, isResultAvailable = 0, result = 0; 
            int flames[];
            flames = new int[] {1, 2, 3, 4, 5, 6};
            
            if (calculated_length == 0) {
            	return 1;
            }
            
            while(isResultAvailable != 5)
            {
                int reachable_count = 0;
                for (int k = 0; k < calculated_length; k++)
                {
                    if (n == 5)
                    {
                        n = 0;
                    }
                    else
                    {
                        n = n + 1;
                    }
                    if (flames[n] < 0)
                    {
                        k = k - 1;
                        // continue;
                    }
                    else
                    {
                        reachable_count = reachable_count + 1;
                        if (reachable_count == calculated_length)
                        {
                        	flames[n] = -1;
                            System.out.println("the removed Value : "+(n+1));
                            isResultAvailable = isResultAvailable + 1;
                            break;
                        }
                    }
                    
                    
                }
            }
            for(int l = 0 ; l < flames.length; l++)
            {
                if (flames[l] > 0)
                {
                    System.out.println("the returned Value : "+flames[l]);
                    result = flames[l];
                }
            }
		return result;
	}

	private int getActualLengthtoCalculate(String userName, String crushName) {
		int actual_length = (userName+crushName).toCharArray().length;
        char usrNameArray[] = userName.toLowerCase().toCharArray();
        char crushArray[] = crushName.toLowerCase().toCharArray();
        int duplicate_element = 0, lcCalculatedLength;
        for (int i = 0; i < usrNameArray.length; i++)
        {
            for (int j = 0; j < crushArray.length; j++)
            {
                if (crushArray[j] == usrNameArray[i])
                {
                    duplicate_element = duplicate_element + 1;
                    break;
                }
            }
        }
        System.out.println("actual length : "+ actual_length+" duplicated element "+ duplicate_element);
        lcCalculatedLength = ((actual_length) - (duplicate_element * 2));
		return lcCalculatedLength;
	}

}
