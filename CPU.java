
public class CPU {
  enum Diff{Easy,Medium,Hard};
  private Diff d;
  
  public CPU(int dif){
	  if(dif<=3){
		  d= Diff.Easy;
	  }
	  if(dif>3&&dif<=5){
		  d=Diff.Medium;
	  }
	  if(dif>5&&dif<=10){
		  d=Diff.Hard;
	  }
  }
}
