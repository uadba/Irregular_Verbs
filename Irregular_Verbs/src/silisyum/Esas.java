package silisyum;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Esas {

	public static void main(String[] args) {
				
		boolean devam_et = true;
		Scanner s = new Scanner(System.in);
		
		while (devam_et) {			
			Verbs v = new Verbs();
			int how_many_verbs_are_there = 134;
			int r[] = new int[how_many_verbs_are_there];
			for (int j = 0; j < how_many_verbs_are_there; j++)
			{
				r[j] = j;
			}
			shuffleArray(r);
			
			boolean bilmedigi_var = true;
			while (bilmedigi_var)
			{
				bilmedigi_var = false;
				for (int i = 0; i < how_many_verbs_are_there; i++) {

					if (v.list[r[i]][3].equals("bilmiyor")) {
						//System.out.println(v.list[i][0] + "\t" + v.list[i][1] + "\t" + v.list[i][2]);
						//if (8==8) continue;
						v.list[r[i]][3] = "biliyor";
						String verb = v.list[r[i]][0];
						String simple_past = v.list[r[i]][1];
						String past_participle = v.list[r[i]][2];
						System.out.println("__________________________________________");
						System.out.println("[" + (i + 1) + "/" + how_many_verbs_are_there + "]");
						System.out.println("[ " + verb + " ]");
						System.out.print("Simple past: ");
						String answer_simple_past = s.nextLine();
						if (answer_simple_past.equals(simple_past)) {
							System.out.println("True!");
						} else {
							System.out.println("False. The answer should have been '" + simple_past
									+ "' ***********************************");
							v.list[r[i]][3] = "bilmiyor";
							bilmedigi_var = true;
						}
						System.out.print("Past participle: ");
						String answer_past_participle = s.nextLine();
						if (answer_past_participle.equals(past_participle)) {
							System.out.println("True!");
						} else {
							System.out.println("False. The answer should have been '" + past_participle
									+ "' ***********************************");
							v.list[r[i]][3] = "bilmiyor";
							bilmedigi_var = true;
						}
						System.out.println("------------------------------------------");
					}

				} 
			}
			
			System.out.println("Test is completed!.. Do you repeat it? (yes/no)");
			String cevap = s.nextLine();
									
			if(!cevap.equals("yes"))
			{
				devam_et = false;
			}
		}
		s.close();		
		
	}
	
	  static void shuffleArray(int[] ar)
	  {
	    // If running on Java 6 or older, use `new Random()` on RHS here
	    Random rnd = ThreadLocalRandom.current();
	    for (int i = ar.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      // Simple swap
	      int a = ar[index];
	      ar[index] = ar[i];
	      ar[i] = a;
	    }
	  }

}