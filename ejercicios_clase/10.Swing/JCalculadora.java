/*
COMPILAR CON LIBRERIAS EN LINUX: javac JCalculadora.java -cp .:exp4j-0.4.8.jar
COMPILAR CON LIBRERIAS EN WINDOWS: javac JCalculadora.java -cp .;exp4j-0.4.8.jar
EJECUTAR CON LIBRERIAS EN LINUX: java -cp .:exp4j-0.4.8.jar JCalculadora
EJECUTAR CON LIBRERIAS EN WINDOWS: java -cp .;exp4j-0.4.8.jar JCalculadora
*/

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class JCalculadora extends JFrame implements ActionListener{
  JTextField txtCalculo;
  HashMap<JButton,String> hmBtns;
  public static void main(String argv[]){
    new JCalculadora();
  }

  public JCalculadora(){
    super("Super calculadora");
    hmBtns = new HashMap<>();
    init();
    this.setVisible(true);
  }

  private void init() {
    txtCalculo = new JTextField();
    txtCalculo.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20 ));
    this.add(txtCalculo,BorderLayout.NORTH);

    JPanel pnlCenter = new JPanel();
    pnlCenter.setLayout(new GridLayout(6,4));

    String[] literalBotones = {"%","CE","C","<","1/x","x^2","2√x","÷","7","8","9","X","4","5","6","-","1","2","3","+","+/-","0",".","="};
    for(String literal : literalBotones){
      JButton b = new JButton(literal);
      b.addActionListener(this);
      hmBtns.put(b,literal);
      pnlCenter.add(b);
    }

    //for (JButton b : hmBtns.values())
    //  pnlCenter.add(b);

    //hmBtns.values().forEach(b -> pnlCenter.add(b));

    this.add(pnlCenter, BorderLayout.CENTER);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(400,400);
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    String key = hmBtns.get(e.getSource());

    if (!"=".equals(key)) {
      txtCalculo.setText(txtCalculo.getText()+hmBtns.get(e.getSource()));
      return;
    }
    
    String expr = txtCalculo.getText()
        .replace("X", "*")
        .replace("x", "*")
        .replace("÷", "/")
        .replace("%", "/100");
    Expression expression = new ExpressionBuilder(expr).build();
    double result = expression.evaluate();
    txtCalculo.setText(String.valueOf(result));
    
  }
}
