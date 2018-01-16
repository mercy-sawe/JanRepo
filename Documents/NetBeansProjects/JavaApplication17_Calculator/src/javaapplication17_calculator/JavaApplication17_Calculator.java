/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication17_calculator;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.JTextArea;

/**
 *
 * @author mercysawe
 */
public class JavaApplication17_Calculator implements ActionListener {
 //the variables
    JFrame javaframe;
    JPanel javapanel2;
    JPanel javapanel;
    JTextField jtf;
    JTextArea jta;
    double operation=0;
    double currentcalc=1;
    private String operator;
    
     

    
    Font myFont=new Font("HELVETICA",Font.BOLD+Font.PLAIN,17);
   
    ArrayList<String> numbers=new ArrayList<>();
    ArrayList<String> signs=new ArrayList<>();
    ArrayList<String> quiz=new ArrayList<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EventQueue.invokeLater(new Runnable()
         {  
            @Override
             public void run()
             {
                 new JavaApplication17_Calculator();         
             }
         });
    }
    
      public JavaApplication17_Calculator(){
        javaframe=new JFrame();
        javaframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        javaframe.setTitle("My Calculator");
        javaframe.setSize(300,250);
        javaframe.setLocationRelativeTo(null);
        
        jtf = new JTextField();
        jtf.setHorizontalAlignment(JTextField.RIGHT);
        jtf.setFont(myFont);
        jtf.setEditable(false);
        jtf.setPreferredSize(new java.awt.Dimension(500,50));
        
    
        //Make a Grid that has three rows and four columns    
        javaframe.add(jtf, BorderLayout.NORTH);   
    
        javapanel=new JPanel();
        javapanel.setLayout(new GridLayout(4,3));
        javaframe.add(javapanel,BorderLayout.LINE_START);
        
        JButton resetB=new JButton("Reset");
        JButton onoffB=new JButton("On/Off");
         JButton delB=new JButton("DEL");
         
         
     for (int m=9;m>=0;m--)
        {
            
            addButton(javapanel, String.valueOf(m));
            
        }
         
         JButton pointButton = new JButton(".");
         pointButton.setActionCommand(".");
        
        JavaApplication17_Calculator.OperatorAction pointAction = new JavaApplication17_Calculator.OperatorAction(1);       
        //lets user see the signs he/she is typingin the calc.
        pointButton.addActionListener(new ActionListener(){
        	@Override
        		public void actionPerformed(ActionEvent event)
        		{
        			calculate(".");
        		}
        	});
         
          javapanel2=new JPanel();
            javapanel2.setLayout(new GridLayout(4,2));
        javaframe.add(javapanel2,BorderLayout.AFTER_LINE_ENDS);
         
         JButton addButton = new JButton("+");
         addButton.setActionCommand("+");
        
        JavaApplication17_Calculator.OperatorAction subAction = new JavaApplication17_Calculator.OperatorAction(1);       
        //lets user see the signs he/she is typingin the calc.
        addButton.addActionListener(new ActionListener(){
        	@Override
        		public void actionPerformed(ActionEvent event)
        		{
        			calculate("+");
        		}
        	});
        
         JButton subButton = new JButton("-");
        subButton.setActionCommand("-");
        
        JavaApplication17_Calculator.OperatorAction addAction = new JavaApplication17_Calculator.OperatorAction(2);
        subButton.addActionListener(new ActionListener(){
       	@Override
       		public void actionPerformed(ActionEvent event){
       			calculate("-");
       		}
       	});
        
          JButton prodButton=new JButton("*");
        prodButton.setActionCommand("*");
        
        JavaApplication17_Calculator.OperatorAction divAction= new JavaApplication17_Calculator.OperatorAction(3);
        prodButton.addActionListener(new ActionListener(){
       	@Override
       		public void actionPerformed(ActionEvent event){
       			calculate("*");
       		}
       	});
                      
        JButton divButton=new JButton("/");
        divButton.setActionCommand("/");
        
        JavaApplication17_Calculator.OperatorAction prodAction= new JavaApplication17_Calculator.OperatorAction(4);
        divButton.addActionListener(new ActionListener(){
       	@Override
       		public void actionPerformed(ActionEvent event){
       			calculate("/");
       		}
       	});
      
        JButton equalsButton = new JButton("=");
        equalsButton.setActionCommand("=");
        equalsButton.addActionListener(new ActionListener()
        	{
        		@Override
        			public void actionPerformed(ActionEvent event){
        				calculate("=");
        			}
        	}
        	);
        
        equalsButton.addActionListener(new ActionListener()
        	{
        		@Override
        			public void actionPerformed(ActionEvent event){
        				
        			}
        	});
       
         javapanel2.add(resetB);
          javapanel2.add(onoffB);
        javapanel.add(pointButton);
        javapanel2.add(addButton);
        javapanel2.add(subButton);
        javapanel2.add(prodButton);
        javapanel2.add(divButton);
        javapanel2.add(equalsButton);
         javapanel2.add(delB);
        
         resetB.addActionListener(this);
         onoffB.addActionListener(this);
         pointButton.addActionListener(this);
         delB.addActionListener(this);
         
        javaframe.setVisible(true);  
    }
      
      public void calculate(String action)
     {
     	String number=jtf.getText();
     	int n=number.length();
    
     		if((number+action).equals("+") || (number+action).equals("-") ||(number+action).equals("*")  
                        ||(number+action).equals("/")  ||(number+action).equals("=")||(number+action).equals(".") || currentcalc==2)
     		{
                   
     		}
     		
     	else if(numbers.size()==0)
     	{	
     		if(action.equals("="))
     		{
     		numbers.add(number);
     		quiz.add(0,number+action);
     		jtf.setText(number+action);
     			sum();
     		}else
     		{
     			numbers.add(number);
     		signs.add(action);
     		quiz.add(0,number+action);
     		jtf.setText(number+action);
     		}
     	}
     	else if(numbers.size()>0)
        {
     		 String sumfromquiz=quiz.get(0);
     		 int length=sumfromquiz.length();
     		 String addednumber=number.substring(length);
     		
     		   if(action.equals("="))
     		   {
     		   	numbers.add(addednumber);
     		  quiz.set(0,(number+action));
     		  jtf.setText(number+action);
     		   		sum();
     		   }
     		   else
     		   	{
     		   	numbers.add(addednumber);
     		  signs.add(action);
     		  quiz.set(0,(number+action));
     		  jtf.setText(number+action);
     		   }
     	}
     	else{
     		
     	}
     }
      
     
      //method that calculates all the numbers
      public void sum()
    {
    	
    	while(numbers.size()!=1)
    	{
            float d1=Integer.parseInt(numbers.get(0));
            float d2=Integer.parseInt(numbers.get(1));
            float d3=0;
            String operand=signs.get(0);
            if(operand.equals("+"))
            {
                d3=d1+d2;
            } if(operand.equals("-"))
            {
                d3=d1-d2;
            }if(operand.equals("*")){
                d3=d1*d2;
            }if(operand.equals("/")){
                d3=d1/d2;
            }if(operand.equals("."))
            {
               //code for decimal point
            }
            numbers.remove(0);
            String d3s=d3+"";
            numbers.set(0, d3s);
            signs.remove(0);
    	}
    	
    	jtf.setText(quiz.get(0)+" "+numbers.get(0));
    	quiz.clear();
    	signs.clear();
    	numbers.clear();
    	currentcalc = 2;
    	
    }
      
        private void addButton(Container parent, String name)
    {
        JButton but = new JButton(name);
        but.setActionCommand(name);
        but.addActionListener(this);
        parent.add(but);
    }
     @Override
    public void actionPerformed(ActionEvent event)
    {
        //get the Action Command text from the button
        String action = event.getActionCommand();
        
        //set the text using the Action Command text
        if(currentcalc==2){
        	jtf.setText("");
        	jtf.setText(jtf.getText().trim()+action); 
        		currentcalc = 1;  
        }    
        	else{
        		jtf.setText(jtf.getText().trim()+action);   
        	}
    }
    
    private class OperatorAction implements ActionListener
    {
        private int operator;
        
        public OperatorAction(int operation)
        {
            operator = operation;
        }
        
        public void actionPerformed(ActionEvent event)
        {
            currentcalc = Integer.parseInt(jtf.getText()); 
            operation = operator;
        }
    }
 
    
    
}   
    
    

