import java.util.*;
import java.io.*;

// write your matric number here:
// write your name here:
// write list of collaborators here:
// year 2015 hash code: JESg5svjYpIsmHmIjabX (do NOT delete this line)

class BabyNames {
    TreeSet<Babies> ts; 
	
	class Babies implements Comparable<Babies>{
		private String babyName;
		private int genderSuitability;
		
		Babies(String babyName, int genderSuitability){
			this.babyName = babyName;
			this.genderSuitability = genderSuitability;
		}
		
		public String getBabyName(){
			return babyName;
		}
		
		public int getGenderSuitabilty(){
			return genderSuitability;
		}

/*		@Override
		public String toString() {
			return "Baby [name=" + babyName + ", genderSuitability=" + genderSuitability + "]";
		}	*/
	
		public int compareTo(Babies other) {	
			if(this.getBabyName().compareTo(other.getBabyName()) > 0) {return 1;}
			if(this.getBabyName().compareTo(other.getBabyName()) < 0) {return -1;}
			return 0;
		}
		
/*		 public boolean equals(Object obj) {  
		        if (this == obj)  
		            return true;  
		        if (!(obj instanceof Babies))  
		            return false;  
		        final Babies other = (Babies) obj;  
		  
		        if (this.babyName.equals(other.getBabyName()) && this.genderSuitability == other.getGenderSuitabilty())  
		            return true;  
		        else  
		            return false;  
		    }  */		
	}

  public BabyNames() {
	  ts = new TreeSet<Babies>();			 
  }

  void AddSuggestion(String babyName, int genderSuitability) {

	  ts.add(new Babies(babyName,genderSuitability));
	  
	//  System.out.println("iterator the treeset: ");  
	//  System.out.println("add Babies " +ts);
  }

  void RemoveSuggestion(String babyName) {
	  for(Babies bb: ts){
		  if(bb.getBabyName().equals(babyName)) { 
              ts.remove(bb);
		  	break;
              }	 
	  }
//	  System.out.println("interator the treeset: ");
//	  System.out.println("existing babies " + ts);
	  
	/*  Iterator<Babies> it = ts.iterator();
		  while(it.hasNext()){
			  Babies bb = it.next();
			  if (bb.getBabyName().equals(babyName))
				  ts.remove(bb);
			  break;
	  } */
		  }

  int Query(String START, String END, int genderPreference) {
    int ans = 0;

    // You have to answer how many baby name starts
    // with prefix that is inside query interval [START..END)

		for (Babies bb : ts) {
			if(bb.getBabyName().compareTo(START) >= 0 && bb.getBabyName().compareTo(END) < 0 && (bb.getGenderSuitabilty() == genderPreference || genderPreference == 0))
				ans++;
			}
    return ans;
  }

  void run() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int command = Integer.parseInt(st.nextToken());
      if (command == 0) // end of input
        break;
      else if (command == 1) // AddSuggestion
        AddSuggestion(st.nextToken(), Integer.parseInt(st.nextToken()));
      else if (command == 2) // RemoveSuggestion
        RemoveSuggestion(st.nextToken());
      else // if (command == 3) // Query
        pr.println(Query(st.nextToken(), // START
                         st.nextToken(), // END
                         Integer.parseInt(st.nextToken()))); // GENDER
    }
    pr.close();
  }

  public static void main(String[] args) throws Exception {
    BabyNames ps2 = new BabyNames();
    ps2.run();
  }
}
