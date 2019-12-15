package projectFont;
	import javax.swing.*;
	import java.awt.*;
	import java.awt.GraphicsEnvironment;
	
	public class Principal extends JPanel
	{
		private String style;
		private String input;
		
		public void setStyle(String style)
		{
			this.style = style;
		}
		public void setInput(String input)
		{
			this.input = input;
		}

		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			Font myFont = new Font(style, Font.PLAIN, 40);
			g2.setFont(myFont);
			g2.drawString(input, 100,100);
			
		}
		
		public static void main(String[] args) 
		{
			boolean fontAvailable = false;
			String style = JOptionPane.showInputDialog("Introduce Font Style");
			//Principal set = new Principal();
			//set.setStyle(style);
			
			//String input;
			String[] nombresDeFuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
			for (String string : nombresDeFuentes) {
				if(string.equals(style))
				{
					fontAvailable = true;
				}
			}
			if(fontAvailable)
			{
				String input = JOptionPane.showInputDialog("Introduce some text:");
				Principal set = new Principal();
				set.setStyle(style);
				set.setInput(input);
				
				Frame myFrame = new Frame();
				myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				myFrame.add(set);
				
			}else {
				System.out.println("Unavailable Font");
			}
		
		}

	}
	class Frame extends JFrame
	{
		public Frame()
		{
			setVisible(true);
			setTitle("MycustomText.com");
			Toolkit myScreen = Toolkit.getDefaultToolkit();
			Dimension screenSize = myScreen.getScreenSize();
			int screenHeight = screenSize.height;
			int screenWidth = screenSize.width;
			setBounds(screenWidth/4, screenHeight/4, screenWidth/2, screenHeight/2);
			
		}
	}
