import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class notepad extends JFrame implements ActionListener
{
JMenuBar mb;
JMenu m1,m2,m3,m4,m5;
JMenuItem n,o,s,c, cu,co,pa,de,sa,colors;
JCheckBoxMenuItem wordwrap;
JTextArea ta;
FileDialog fd;
String buffer;
JScrollPane sp;
notepad()
{

Font f = new Font("Arial", Font.BOLD, 15);

ta= new JTextArea();
sp = new JScrollPane(ta);
add(sp);
ta.setFont(new Font("Arial", Font.BOLD, 20));

mb=new JMenuBar();
add(mb,BorderLayout.NORTH);
m1=new JMenu("File");
m1.setMnemonic('F'); 
mb.add(m1);
m1.setFont(f);

m2=new JMenu("Edit");
m2.setMnemonic('E'); 
mb.add(m2);
m2.setFont(f);

m3=new JMenu("Format");
m3.setMnemonic('t'); 
mb.add(m3);
m3.setFont(f);

m4=new JMenu("View");
m4.setMnemonic('V'); 
mb.add(m4);
m4.setFont(f);

m5=new JMenu("Help");
m5.setMnemonic('H'); 
mb.add(m5);
m5.setFont(f);

n = new JMenuItem("New",new ImageIcon("images/new.gif"));
n.setMnemonic('F');
m1.add(n);
n.setFont(f);
n.addActionListener(this);
n.setBackground(Color.orange);

o = new JMenuItem("Open", new ImageIcon("images/open.gif"));
m1.add(o);
o.setFont(f);
o.addActionListener(this);
o.setBackground(Color.orange);

s = new JMenuItem("Save", new ImageIcon("images/save.gif"));
m1.add(s);
s.setFont(f);
s.addActionListener(this);

m1.addSeparator();

c = new JMenuItem("Close", new ImageIcon("images/close.gif"));
m1.add(c);
c.setFont(f);
c.addActionListener(this);

cu= new JMenuItem("Cut", new ImageIcon("images/cut.gif"));
cu.setFont(f);
m2.add(cu);
cu.addActionListener(this);
co= new JMenuItem("Copy", new ImageIcon("images/copy.gif"));
m2.add(co);
co.setFont(f);
co.addActionListener(this);

pa= new JMenuItem("Paste", new ImageIcon("images/paste.gif"));
m2.add(pa);
pa.setFont(f);
pa.addActionListener(this);

m2.addSeparator();

de= new JMenuItem("Delete", new ImageIcon("images/del.gif"));
m2.add(de);
de.addActionListener(this);
de.setFont(f);

sa= new JMenuItem("Select All", new ImageIcon("images/paste.gif"));
m2.add(sa);
sa.addActionListener(this);
sa.setFont(f);

colors= new JMenuItem("Colors", new ImageIcon("images/fg.gif"));
m3.add(colors);
colors.addActionListener(this);
colors.setFont(f);

wordwrap= new JCheckBoxMenuItem("Word Wrap", new ImageIcon("images/ww.gif"));
m4.add(wordwrap);
wordwrap.addActionListener(this);
wordwrap.setFont(f);
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==c)
System.exit(0);

if(ae.getSource()==n)
ta.setText("");

try
{

if(ae.getSource()==o)
{
fd = new FileDialog(this, "Open",FileDialog.LOAD);
fd.show();
String fname = fd.getDirectory() + "\\" + fd.getFile();
FileInputStream fis = new FileInputStream(fname);
System.out.println(fd.getDirectory()+"/////"+fd.getFile());
byte b[ ] =  new byte[fis.available()];
fis.read(b);
String s = new String (b);
ta.setText(s);
}

if(ae.getSource()==s)
{
fd = new FileDialog(this, "save",FileDialog.SAVE);
fd.show();
String fname = fd.getDirectory() + "\\" + fd.getFile();
FileOutputStream fos = new FileOutputStream(fname);
String s = ta.getText();
byte b[ ]= s.getBytes();
fos.write(b);
fos.close();
javax.swing.JOptionPane.showMessageDialog(null, "File Saved!");
}
}
catch(Exception  e ) { }

if(ae.getSource()==co)
{
buffer  = ta.getSelectedText();
}

if(ae.getSource()==cu)
{
buffer  = ta.getSelectedText();
ta.replaceRange("",ta.getSelectionStart(), ta.getSelectionEnd() );
}

if(ae.getSource()==pa)
{
ta.replaceRange(buffer,ta.getSelectionStart(), ta.getSelectionEnd() );
}

if(ae.getSource()==de)
{
ta.replaceRange("",ta.getSelectionStart(), ta.getSelectionEnd() );
}

if(ae.getSource()==sa)
{
String msg = ta.getText();
ta.setSelectionStart(0);
ta.setSelectionEnd(msg.length());
}

if(ae.getSource()==colors)
{
Color cl =JColorChooser.showDialog(this,"Text Color", ta.getForeground() );
ta.setForeground(cl);
}

if(ae.getSource()==wordwrap)
{
ta.setLineWrap(!ta.getLineWrap());
}

 }

public static void main(String arg[]) throws Exception
{
notepad n= new notepad();
n.resize(500,400);
n.setVisible(true);
}
}


