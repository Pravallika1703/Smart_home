
import java.time.LocalTime;
import java.util.Scanner;

class HEMS
{
	DSMAgent suppl;
	SSMAgent Deman;
	double demandPower=0.0,supplyPower=0.0;
	void calculateSchedule()
	{
	suppl=new DSMAgent(500,200);
	Deman=new SSMAgent();
	demandPower=Deman.getDemand();
	supplyPower=suppl.getSupply();
	System.out.println("Demand is :"+ demandPower);
	System.out.println("Storage power is :"+ supplyPower);
	if(demandPower==supplyPower)
		System.out.println("Total cost is 0");
	else if(demandPower<supplyPower)
		System.out.println(supplyPower-demandPower + "   amount of power is sold to main grid");
	if(demandPower>supplyPower)
	{
		System.out.println("Power to take from Main grid is:  "+ (demandPower-supplyPower));
		if(Deman.AC.getPriority()<=5)
		    Deman.AC.setSchedule("22:00");
		if(Deman.BH.getPriority()<=5)
		    Deman.BH.setSchedule("22:00");
		if(Deman.DC.getPriority()<=5)
		    Deman.DC.setSchedule("22:00");
		if(Deman.EDP.getPriority()<=5)
		    Deman.EDP.setSchedule("22:00");
		if(Deman.EV.getPriority()<=5)
		    Deman.EV.setSchedule("22:00");
		if(Deman.F.getPriority()<=5)
		    Deman.F.setSchedule("22:00");
		if(Deman.IB.getPriority()<=5)
		    Deman.IB.setSchedule("22:00");
		if(Deman.IR.getPriority()<=5)
		    Deman.IR.setSchedule("22:00");
		if(Deman.LT.getPriority()<=5)
		    Deman.LT.setSchedule("22:00");
		if(Deman.RC.getPriority()<=5)
		    Deman.RC.setSchedule("22:00");
		if(Deman.S.getPriority()<=5)
		    Deman.S.setSchedule("22:00");
		if(Deman.SF.getPriority()<=5)
		    Deman.SF.setSchedule("22:00");
		if(Deman.TF.getPriority()<=5)
		    Deman.TF.setSchedule("22:00");
		if(Deman.TLWM.getPriority()<=5)
		    Deman.TLWM.setSchedule("22:00");
		if(Deman.TV.getPriority()<=5)
		    Deman.TV.setSchedule("22:00");
		if(Deman.VC.getPriority()<=5)
		    Deman.VC.setSchedule("22:00");
	}
	}
	public boolean isBetween(LocalTime candidate, LocalTime start, LocalTime end) {
		  return !candidate.isBefore(start) && !candidate.isAfter(end);  // Inclusive.
		}
	void calculateCost()
	{
		long peakPower = 0,offPeakPower=0;

		LocalTime time=LocalTime.parse(Deman.AC.getSchedule());
		if(isBetween(time,LocalTime.of(8,00),LocalTime.of(21,00)))
               peakPower+=Deman.AC.getPower();
		else
			offPeakPower+=Deman.AC.getPower();

		time=LocalTime.parse(Deman.BH.getSchedule());
		if(isBetween(time,LocalTime.of(8,00),LocalTime.of(21,00)))
               peakPower+=Deman.BH.getPower();
		else
			offPeakPower+=Deman.BH.getPower();

		time=LocalTime.parse(Deman.DC.getSchedule());
		if(isBetween(time,LocalTime.of(8,00),LocalTime.of(21,00)))
               peakPower+=Deman.DC.getPower();
		else
			offPeakPower+=Deman.DC.getPower();

		time=LocalTime.parse(Deman.EDP.getSchedule());
		if(isBetween(time,LocalTime.of(8,00),LocalTime.of(21,00)))
               peakPower+=Deman.EDP.getPower();
		else
			offPeakPower+=Deman.EDP.getPower();

		time=LocalTime.parse(Deman.EV.getSchedule());
		if(isBetween(time,LocalTime.of(8,00),LocalTime.of(21,00)))
               peakPower+=Deman.EV.getPower();
		else
			offPeakPower+=Deman.EV.getPower();
		time=LocalTime.parse(Deman.F.getSchedule());
		if(isBetween(time,LocalTime.of(8,00),LocalTime.of(21,00)))
               peakPower+=Deman.F.getPower();
		else
			offPeakPower+=Deman.F.getPower();
		time=LocalTime.parse(Deman.IB.getSchedule());
		if(isBetween(time,LocalTime.of(8,00),LocalTime.of(21,00)))
               peakPower+=Deman.IB.getPower();
		else
			offPeakPower+=Deman.IB.getPower();
		time=LocalTime.parse(Deman.IR.getSchedule());
		if(isBetween(time,LocalTime.of(8,00),LocalTime.of(21,00)))
               peakPower+=Deman.IR.getPower();
		else
			offPeakPower+=Deman.IR.getPower();
		time=LocalTime.parse(Deman.LT.getSchedule());
		if(isBetween(time,LocalTime.of(8,00),LocalTime.of(21,00)))
               peakPower+=Deman.LT.getPower();
		else
			offPeakPower+=Deman.LT.getPower();
		time=LocalTime.parse(Deman.RC.getSchedule());
		if(isBetween(time,LocalTime.of(8,00),LocalTime.of(21,00)))
               peakPower+=Deman.RC.getPower();
		else
			offPeakPower+=Deman.RC.getPower();
		time=LocalTime.parse(Deman.S.getSchedule());
		if(isBetween(time,LocalTime.of(8,00),LocalTime.of(21,00)))
               peakPower+=Deman.S.getPower();
		else
			offPeakPower+=Deman.S.getPower();
		time=LocalTime.parse(Deman.SF.getSchedule());
		if(isBetween(time,LocalTime.of(8,00),LocalTime.of(21,00)))
               peakPower+=Deman.SF.getPower();
		else
			offPeakPower+=Deman.SF.getPower();
		time=LocalTime.parse(Deman.TF.getSchedule());
		if(isBetween(time,LocalTime.of(8,00),LocalTime.of(21,00)))
               peakPower+=Deman.TF.getPower();
		else
			offPeakPower+=Deman.TF.getPower();
		time=LocalTime.parse(Deman.TLWM.getSchedule());
		if(isBetween(time,LocalTime.of(8,00),LocalTime.of(21,00)))
               peakPower+=Deman.TLWM.getPower();
		else
			offPeakPower+=Deman.TLWM.getPower();

		time=LocalTime.parse(Deman.TV.getSchedule());
		if(isBetween(time,LocalTime.of(8,00),LocalTime.of(21,00)))
               peakPower+=Deman.TV.getPower();
		else
			offPeakPower+=Deman.TV.getPower();

		time=LocalTime.parse(Deman.VC.getSchedule());
		if(isBetween(time,LocalTime.of(8,00),LocalTime.of(21,00)))
               peakPower+=Deman.VC.getPower();
		else
			offPeakPower+=Deman.VC.getPower();


		if(peakPower>supplyPower)
			peakPower=(long) (peakPower-supplyPower);
		else
			peakPower=0;
		    offPeakPower=(long) ((long)offPeakPower-supplyPower);
	  double offpeakcost=((double)offPeakPower/1000)*0.08;
	  System.out.println("peak power is: "+ peakPower);
	  System.out.println(" Off peak power is: "+ offPeakPower);

	  double peakcost=((double)peakPower/1000)*0.12;
	  double totalcost=offpeakcost+peakcost;
	  System.out.println("cost of energy usage per day is :  "+totalcost);
      double withoutsmarthome=((double) demandPower/1000)*0.12;
	  System.out.println("cost of energy usage per day without smart home is :  "+withoutsmarthome);

	}
}
class DSMAgent
{
	double solarStorage,evStorage;
	DSMAgent(double ss,double ES)
	{
		solarStorage=ss;
		evStorage=ES;
	}
	double getSupply()
	{
			double supply=0.0;
		String ti="";
		supply=solarStorage+evStorage;
		return supply;
	}
}
class DSM
{
	double power;

	DSM(double power)
	{
		this.power=power;

	}

	double getPower()
	{
		return power;
	}
}
class SSMAgent
{
	public SSM AC,BH,DC,EDP,EV,F,IB,IR,LT,RC,S,SF,TF,TLWM,TV,VC;

	double getDemand()
	{

		double demand=0.0;
		AC=new SSM(10500); //Airconditioner
		BH=new SSM(12000); // bathroom Heater
		DC=new SSM(600);  //desktop computer
		EDP=new SSM(2500);  //clothes dryer
		EV=new SSM(800);   //Electrnic Vehicle
		F=new SSM(225); //  Fan
		IB=new SSM(60);  // Incandescent bulb
		IR=new SSM(275);  // Ironer
		LT=new SSM(360);   // laptop
		RC=new SSM(4320);  //Refrigerator
		S=new SSM(600);   //microwave
		SF=new SSM(2400);   //Oven
		TF=new SSM(240);   // Toaster
		TLWM=new SSM(500);  //Top Loadig washing machine
		TV=new SSM(150);  //TV
		VC=new SSM(224); //vaccum cleaner
		System.out.println("Set priorties for below agents between 1 and 10 ");
		System.out.println("For Aircondiioner:");
		Scanner sc=new Scanner(System.in);
		AC.setPriority(sc.nextInt());
		System.out.println("For Heater:");
		BH.setPriority(sc.nextInt());
		System.out.println("For DesktopComputer:");
		DC.setPriority(sc.nextInt());
		System.out.println("For Clothes dryer:");
		EDP.setPriority(sc.nextInt());
		System.out.println("For Electric vehicle:");
		EV.setPriority(sc.nextInt());
		System.out.println("For Fan:");
		F.setPriority(sc.nextInt());
		System.out.println("For Incandescent Bulb");
		IB.setPriority(sc.nextInt());
		System.out.println("For Ironer:");
		IR.setPriority(sc.nextInt());
		System.out.println("For Laptop:");
		LT.setPriority(sc.nextInt());
		System.out.println("For Refrigerator:");
		RC.setPriority(sc.nextInt());
		System.out.println("For Microwave");
		S.setPriority(sc.nextInt());
		System.out.println("For Oven");
		SF.setPriority(sc.nextInt());
		System.out.println("For Toaster:");
		TF.setPriority(sc.nextInt());
		System.out.println("For washing machine:");
		TLWM.setPriority(sc.nextInt());
		System.out.println("For TV:");
		TV.setPriority(sc.nextInt());
		System.out.println("For Vaccum cleaner:");
		VC.setPriority(sc.nextInt());
		demand=AC.getPower()+BH.getPower()+DC.getPower()+EDP.getPower()+
				EV.getPower()+F.getPower()+IB.getPower()+IR.getPower()+
				LT.getPower()+RC.getPower()+S.getPower()+SF.getPower()+
				TF.getPower()+TLWM.getPower()+TV.getPower()+VC.getPower();
		return demand;
	}

}
class SSM
{
	int importance,needtime;
	double power,costPerUnit;
	String schedule="";
	SSM(double power)
	{
		this.power=power;
		schedule="09:00";
	}
	void setPriority(int imp)
	{
		importance=imp;
	}
	double getPower()
	{
		return power;
	}
	int getPriority()
	{
		return importance;
	}
	void setSchedule(String s)
	{
		schedule=s;
	}
	String getSchedule()
	{
		return schedule;
	}
	int getNeedTime()
	{
		return needtime;
	}
}
public class Multi_project
{
	public static void main(String args[])
	{
				HEMS h=new HEMS();
		h.calculateSchedule();
		h.calculateCost();

    }
}
