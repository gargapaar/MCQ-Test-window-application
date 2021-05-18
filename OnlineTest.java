/*Online Java Paper Test*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class OnlineTest extends JFrame implements ActionListener
{
	JLabel l;
	JRadioButton jb[]=new JRadioButton[5];
	JButton buttonN,buttonP;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];	
	ArrayList<Integer> arr;
	TreeSet<Integer> set;
	OnlineTest(String s)
	{	
		super(s);
		set=new TreeSet<Integer>();
		arr=new ArrayList<Integer>();
		set.add(1);set.add(0);set.add(2);set.add(3);set.add(4);set.add(5);set.add(6);set.add(7);set.add(8);set.add(9);
		for(int i=0;i<10;i++)
		{
			int a=(int)(Math.random()*10);
			Integer var=set.floor(a);
			if(var==null)
			{
				var=set.ceiling(a);
				arr.add(var);
			}
			else
			{
				arr.add(var);
			}
			set.remove(var);
			System.out.println(var);
				
		}
		arr.add(10);
		l=new JLabel();
		add(l);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton();	
			add(jb[i]);
			bg.add(jb[i]);
		}
		buttonN=new JButton("Next");								//button 1
		buttonP=new JButton("Back");					   			//button 2
		buttonN.addActionListener(this);							//button 1
		buttonP.addActionListener(this);							//button 2
		add(buttonN);add(buttonP);
		set();
		l.setBounds(30,40,450,20);
		jb[0].setBounds(50,80,100,20);
		jb[1].setBounds(50,110,100,20);
		jb[2].setBounds(50,140,100,20);
		jb[3].setBounds(50,170,100,20);
		buttonN.setBounds(450,240,100,30);
		buttonP.setBounds(30,240,100,30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(600,350);										
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==buttonN)
		{	
			if(check())
				count=count+1;
			current++;
			set();
			buttonP.setEnabled(true);
	
			if(current==9)
			{
			//	buttonN.setEnabled(false);
				buttonN.setText("Submit");
			}
		}

		if(e.getSource()==buttonP)
		{	
			if(check())
				count=count-1;
			current--;
			set();	
			buttonN.setEnabled(true);
			buttonN.setText("Next");
			if(current==0)
			{
				buttonP.setEnabled(false);
			}
		}
	
		if(e.getActionCommand().equals("Submit"))
		{
			if(check())
				count=count+1;
			current++;
			//System.out.println("correct Answer = "+count);
			JOptionPane.showMessageDialog(this,"Correct Answers = "+count);
			System.exit(0);
		}
	}
	void set()
	{
		jb[4].setSelected(true);
		if(arr.get(current)>9)
			{
				return;
			}
		if(arr.get(current)==0)
		{
			l.setText("Que" + (current+1) +" : Which one among these is not a datatype");
			jb[0].setText("int");jb[1].setText("Float");jb[2].setText("boolean");jb[3].setText("char");	
		}
		if(arr.get(current)==1)
		{
			l.setText("Que" + (current+1) +": Which class is available to all the class automatically");
			jb[0].setText("Swing");jb[1].setText("Applet");jb[2].setText("Object");jb[3].setText("ActionEvent");
		}
		if(arr.get(current)==2)
		{
			l.setText("Que" + (current+1) +": Which package is directly available to our class without importing it");
			jb[0].setText("swing");jb[1].setText("applet");jb[2].setText("net");jb[3].setText("lang");
		}
		if(arr.get(current)==3)
		{
			l.setText("Que" + (current+1) +": String class is defined in which package");
			jb[0].setText("lang");jb[1].setText("Swing");jb[2].setText("Applet");jb[3].setText("awt");
		}
		if(arr.get(current)==4)
		{
			l.setText("Que" + (current+1) +": Which institute is best for java coaching");
			jb[0].setText("Utek");jb[1].setText("Aptech");jb[2].setText("SSS IT");jb[3].setText("jtek");
		}
		if(arr.get(current)==5)
		{
			l.setText("Que" + (current+1) +": Which one among these is not a keyword");
			jb[0].setText("class");jb[1].setText("int");jb[2].setText("get");jb[3].setText("if");
		}
		if(arr.get(current)==6)
		{
			l.setText("Que" + (current+1) +": Which one among these is not a class ");
			jb[0].setText("Swing");jb[1].setText("Actionperformed");jb[2].setText("ActionEvent");jb[3].setText("Button");
		}
		if(arr.get(current)==7)
		{
			l.setText("Que" + (current+1) +": which one among these is not a function of Object class");
			jb[0].setText("toString");jb[1].setText("finalize");jb[2].setText("equals");jb[3].setText("getDocumentBase");		
		}
		if(arr.get(current)==8)
		{
			l.setText("Que" + (current+1) +": which function is not present in Applet class");
			jb[0].setText("init");jb[1].setText("main");jb[2].setText("start");jb[3].setText("destroy");
		}
		if(arr.get(current)==9)
		{
			l.setText("Que" + (current+1) +": Which one among these is not a valid component");
			jb[0].setText("JButton");jb[1].setText("JList");jb[2].setText("JButtonGroup");jb[3].setText("JTextArea");
		}
		l.setBounds(30,40,450,20);
		for(int i=0,j=0;i<=90;i+=30,j++)
			jb[j].setBounds(50,80+i,200,20);
	}
	boolean check()
	{
		if(arr.get(current)>9)
			{
				return false;
			}
		if(arr.get(current)==0)
			return(jb[1].isSelected());
		if(arr.get(current)==1)
			return(jb[2].isSelected());
		if(arr.get(current)==2)
			return(jb[3].isSelected());
		if(arr.get(current)==3)
			return(jb[0].isSelected());
		if(arr.get(current)==4)
			return(jb[2].isSelected());
		if(arr.get(current)==5)
			return(jb[2].isSelected());
		if(arr.get(current)==6)
			return(jb[1].isSelected());
		if(arr.get(current)==7)
			return(jb[3].isSelected());
		if(arr.get(current)==8)
			return(jb[1].isSelected());
		if(arr.get(current)==9)
			return(jb[2].isSelected());
		return false;
	}
	public static void main(String s[])
	{
		new OnlineTest("Online Test Of Java");
	}


}
