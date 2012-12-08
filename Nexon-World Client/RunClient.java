/* RunClient - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;


public class RunClient extends Applet implements ActionListener {

	private Robot robot;
	private static final long serialVersionUID = 1L;
	public static Properties params = new Properties();
	public JFrame mainFrame;
	public JPanel mainPane = new JPanel();
	public static String mainurl = "nexon.no-ip.biz";
	public int lang = 0;
	public String frameName = "Nexon-World Deskop Client 1.05";
	public JPanel totalPanel;
	private JMenuBar menuBar = new JMenuBar();
	private int capNum;
	private FilenameFilter filter = new FilenameFilter() {

		@Override
		public boolean accept(File arg0, String arg1) {
			if (arg0.getName().equals("images") && arg1.endsWith("png")) {
				return true;
			}
			return false;
		}
		
	};
	public static final Object[][] JMENU_BUTTONS = new Object[][]{{"File", new JMenuItem("New Client"), new JSeparator(), new JMenuItem("Exit")}, {"Guides", new JMenuItem("Getting Started"), new JMenuItem("Fighting Monsters"), new JMenuItem("Money Making")}, {"Links", new JMenuItem("Wiki"), new JMenuItem("Forums"), new JMenuItem("Youtube"), new JMenuItem("Donate")}, {"Tools", new JMenuItem("Take a screenshot")}};
	public static boolean rs = false;

	public static void main(String[] strings) {
		for (int i = 0; i < strings.length; i++) {
			if (strings[i].equalsIgnoreCase("servaddr"))
				mainurl = strings[++i];
		}
		RunClient runclient = new RunClient();
		runclient.doFrame();
	}

	public RunClient() {
		try {
			loadCaptureAmts();
			robot = new Robot();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void loadCaptureAmts() {
		capNum = new File("./images/").listFiles(filter).length;
	}

	public void init() {
		doApplet();
	}

	void doApplet() {
		try {
			readVars();
			startClient();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public void doFrame() {
		try {
			readVars();
			openFrame();
			startClient();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public void readVars() throws IOException {
		params.put("cabbase", "g.cab");
		params.put("java_arguments", "-Xmx1024m -Dsun.java2d.noddraw=true");
		params.put("colourid", "0");
		params.put("worldid", "16");
		params.put("lobbyid", "15");
		params.put("demoid", "0");
		params.put("demoaddress", "");
		params.put("modewhere", "0");
		params.put("modewhat", "0");
		params.put("lang", "0");
		params.put("objecttag", "0");
		params.put("js", "1");
		params.put("game", "0");
		params.put("affid", "0");
		params.put("advert", "1");
		params.put("settings", "wwGlrZHF5gJcZl7tf7KSRh0MZLhiU0gI0xDX6DwZ-Qk");
		params.put("country", "0");
		params.put("haveie6", "0");
		params.put("havefirefox", "1");
		params.put("cookieprefix", "");
		params.put("cookiehost", "nexon.no-ip.biz");
		params.put("cachesubdirid", "0");
		params.put("crashurl", "");
		params.put("unsignedurl", "");
		params.put("sitesettings_member", "1");
		params.put("frombilling", "false");
		params.put("sskey", "");
		params.put("force64mb", "false");
		params.put("worldflags", "8");
		params.put("lobbyaddress", mainurl);
	}

	public void openFrame() {
		JPopupMenu.setDefaultLightWeightPopupEnabled(false);
		mainPane.setLayout(new BorderLayout());
		mainPane.add(this);
		mainPane.setPreferredSize(new Dimension(765, 503));
		totalPanel = new JPanel();
		totalPanel.setPreferredSize(new Dimension(765, 503));
		totalPanel.setLayout(new BorderLayout());
		totalPanel.add(mainPane, BorderLayout.CENTER);
		mainFrame = new JFrame(frameName);
		mainFrame.setLayout(new BorderLayout());
		mainFrame.getContentPane().add(totalPanel, BorderLayout.CENTER);
		mainFrame.setDefaultCloseOperation(3);
		setMenuBar();
		mainFrame.pack();
		mainFrame.setVisible(true);
	}

	private void setMenuBar() {
		int id = 0;
		for (int y = 0; y < JMENU_BUTTONS.length; y++) {
			JMenu menu = new JMenu();
			for (int i = 0; i < JMENU_BUTTONS[y].length; i++) {
				if (i == 0) {
					menu.setText((String) JMENU_BUTTONS[y][i]);
				} else if (JMENU_BUTTONS[y][i] instanceof JMenuItem){
					JMenuItem item = (JMenuItem) JMENU_BUTTONS[y][i];
					menu.add(item);
					item.setActionCommand(""+ id++);
					item.addActionListener(this);
				} else {
					menu.add((JSeparator) JMENU_BUTTONS[y][i]);
				}
			}
			menuBar.add(menu);
		}
		mainFrame.setJMenuBar(menuBar);
		
	}

	public void startClient() {
		try {
			//RuntimeLoader loader = new RuntimeLoader();
			//Class clientclass = loader.loadClass("client");

			//Applet clientApplet = (Applet) clientclass.newInstance();
			//clientclass.getMethod("provideLoaderApplet",
			//		new Class[] { java.applet.Applet.class }).invoke(null,
			//				new Object[] { this });
			//clientApplet.init();
			//clientApplet.start();
			client.provideLoaderApplet(this);
			client var_client = new client();
			var_client.init();
			var_client.start();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public String getParameter(String string) {
		return (String) params.get(string);
	}

	public URL getDocumentBase() {
		return getCodeBase();
	}

	public URL getCodeBase() {
		URL url;
		try {
			url = new URL(new StringBuilder().append("http://").append(mainurl)
					.toString());
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
		return url;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Integer.parseInt(e.getActionCommand())) {
		case 0:
			try {
				Runtime.getRuntime().exec("java -jar dementhium-loader.jar");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 1:
			if (JOptionPane.showConfirmDialog(this, "Are you sure you want to quit?") == 0)
				System.exit(0);
			break;
		case 2:
			browse("http://dementhium.wikia.com/wiki/Getting_Started");
			break;
		case 3:
			browse("http://forums.dementhium.com/showthread.php?t=143");
			break;
		case 4:
			browse("http://dementhium.wikia.com/wiki/Dementhium_Wiki");
			break;
		case 5:
			browse("http://dementhium.wikia.com/wiki/Dementhium_Wiki");
			break;
		case 6:
			browse("http://nexon-world.enjin.com/");
			break;
		case 7:
			browse("http://www.youtube.com/DementhiumOfficial");
			break;
		case 8:
			browse("http://nexon-world.enjin.com/donate");
			break;
		case 9:
			writeImage(robot.createScreenCapture(getGameScreenRectangle()));
			break;
		default:
			System.out.println(Integer.parseInt(e.getActionCommand()));
		}
		
	}

	private Rectangle getGameScreenRectangle() {
		Rectangle rect = getBounds();
		rect.setLocation(this.getLocationOnScreen());
		return rect;
	}

	private void writeImage(BufferedImage createScreenCapture) {
		try {
			ImageIO.write(createScreenCapture, "PNG", new File("./images/capture-" + capNum++ + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void browse(String string) {
		if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
			try {
				Desktop.getDesktop().browse(new URI(string));
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (URISyntaxException e1) {
				e1.printStackTrace();
			}
		}
		
	}

}
