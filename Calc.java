import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame.*;
import java.awt.event.*;
import java.util.regex.*;

import javax.swing.plaf.metal.MetalButtonUI;
class Calc  implements ActionListener{

	JTextField fnt,snt,rest;
	JLabel fn,sn,res;
	JButton  plus,min,div,mod,mul,cls;
	JFrame f;

	public  Calc(){
		f= new JFrame("calc");
		f.setVisible(true);
		//f.setTitle("bubu");
		f.setSize(250,220);
		f.setLayout(null);	
		
	}
	private void items(){
		fn = new JLabel("First Number");
		sn = new JLabel("Second Number");
		res = new JLabel("Result");
		fnt= new JTextField();
		snt= new JTextField();
		rest= new JTextField();
		rest.setEditable(false);
		f.add(fn);
		fn.setBounds(10,10,100,10);
		f.add(sn); 
		sn.setBounds(10,40,100,10);
		f.add(res); 
		res.setBounds(10,70,100,10);
		f.add(fnt);
		fnt.setBounds(120,10,100,20);
		f.add(snt);
		snt.setBounds(120,40,100,20);
		f.add(rest);
		rest.setBounds(120,70,100,20);
	}
	
	private void buttons(){
		plus= new JButton("+"); //plus.setVisible(true);
		min= new JButton("-");
		div= new JButton("/");
		mod= new JButton("%");
		mul= new JButton("*");
		cls= new JButton("CLEAR");

		plus.addActionListener(this);
		min.addActionListener(this);
		div.addActionListener(this);
		mod.addActionListener(this);
		mul.addActionListener(this);
		cls.addActionListener(this);
		f.add(plus);
		plus.setBounds(10,95,100,25);
		//plus.setUI(new MetalButtonUI());
		
		f.add(mul);
		mul.setBounds(10,125,100,25);
		f.add(mod);
		mod.setBounds(10,155,100,25);
		f.add(min);
		min.setBounds(120,95,100,25);
		f.add(div);
		div.setBounds(120,125,100,25);
		f.add(cls);
		cls.setBounds(120,155,100,25);
		
	}

	public void actionPerformed(ActionEvent e){
			
			long p1,p2;
		String result="0";
		if(e.getActionCommand().equals("CLEAR")){
			fnt.setText("");
			snt.setText("");
			}	
		else if(!(Pattern.matches("\\d+",fnt.getText()) && Pattern.matches("\\d+",snt.getText()))){
			result="Invalid";
		}	
		else{
			p1= Integer.parseInt(fnt.getText());
			p2= Integer.parseInt(snt.getText());
		
			
			if(e.getActionCommand().equals("+")){
				result= (p1+p2)+"";
			}
			else if(e.getActionCommand().equals("-")){
				result= (p1-p2)+"";
			}
			else if(e.getActionCommand().equals("*")){
				result= (p1*p2)+"";
			}
			else if(e.getActionCommand().equals("/")){
				result= (p1/p2)+"";
			}
			else if(e.getActionCommand().equals("%")){
				result= (p1%p2)+"";
			}
			
		}
		rest.setText(result);
	}

	public static void main(String[] args){
		Calc bu= new Calc();
		bu.items();
		bu.buttons();
		
		
	}

}