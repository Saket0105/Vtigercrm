package CommonUtil;

import java.util.Random;

public class JavaUtil {
public int getRandomNumber() {
	Random r=new Random();
	int var = r.nextInt(10000);
	return var;
	
	
}
}
