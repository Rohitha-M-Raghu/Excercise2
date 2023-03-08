import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

//Browser Class
class Browser {
	Browser() {
		System.out.println("Browser Object Created... ");
	}

	public void whoAmI() {
		System.out.println("I am a browser");
	}
}

//MultipleAccountnewContainer interface
interface MultipleAccountnewContainer {
	public void addnewContainer(String newContainer);

	public void leaveContainer(String remContainer);
}

//Chrome
class GoogleChrome extends Browser {
	private final String versionNumber = "1.0";
	private static boolean isLocationAccessible;
	private static boolean isCameraAccessible;
	private static boolean isMicrophoneAccessible;
	private static int numberOfTabs = 0;		//primitive integer

	GoogleChrome() {
		super();
		GoogleChrome.numberOfTabs ++;
	}

	@Override
	public void whoAmI() {
		System.out.println("I am GoogleChrome");
	}
	
	public static Integer getNumberOfChromeTabs() {		//boxing
		return Integer.valueOf(numberOfTabs);		
	}


	public static void setPermission() {
		GoogleChrome.isCameraAccessible = true;
		GoogleChrome.isLocationAccessible = true;
		GoogleChrome.isMicrophoneAccessible = true;
		System.out.println("Accessing Camera...");
		System.out.println("Accessing Location...");
		System.out.println("Accessing Microphone...");
	}

	public static void setPermission(boolean camera, boolean location, boolean microphone) {
		GoogleChrome.isCameraAccessible = camera;
		GoogleChrome.isLocationAccessible = location;
		GoogleChrome.isMicrophoneAccessible = microphone;
		if(GoogleChrome.isCameraAccessible = true) {
			System.out.println("Accessing Camera...");
		}
		else if(GoogleChrome.isLocationAccessible = true) {
			System.out.println("Accessing Location...");
		}
		else if(GoogleChrome.isMicrophoneAccessible = true) {
			System.out.println("Accessing Microphone...");
		}
	}

	public static void resetPermission() {
		GoogleChrome.isCameraAccessible = false;
		GoogleChrome.isLocationAccessible = false;
		GoogleChrome.isMicrophoneAccessible = false;
		System.out.println("Stopped Accessing Location, Camera & Microphone!!!");
	}
}

//Firefox
class Firefox extends Browser implements MultipleAccountnewContainer {
	private static HashSet<String> containers = new HashSet<String>(5);
	private static Integer numberOfTabs = 0;		//Integer Object Type

	Firefox() {
		super();
		Firefox.numberOfTabs ++;
//		System.out.println("Firefox Object Created... ");
	}
	
	public static int getNumberOfFirefoxTabs() {
		return numberOfTabs.intValue();			//unboxing
	}
	@Override
	public void whoAmI() {
		System.out.println("I am Firefox");
	}

	@Override
	public void addnewContainer(String newContainer) {
		if (containers.contains(newContainer)) {
			System.out.println(newContainer + " already exists");
		} else {
			containers.add(newContainer);
		}
	}

	@Override
	public void leaveContainer(String remContainer) {
		// leave newContainer
		if (!containers.contains(remContainer)) {
			System.out.println(remContainer + " doesn't exist inside the container");
		} else {
			containers.remove(remContainer);
		}
	}
}

public class SampleOops {
	protected static Map<String, Firefox> firefoxTab = new HashMap<>();
	protected static Map<String, GoogleChrome> chromeTab = new HashMap<>();
	public static void main(String[] args) {
		while(true) {
			mainMenu();
		}
		
//		Browser tabOne = new GoogleChrome();
//		Browser tabTwo = new Firefox();
//		Browser tabThree = new Firefox();
//		Browser tabFour = new GoogleChrome();
//		Browser tabFive = new GoogleChrome();
//		Browser[] allBrowsers = new Browser[5];
//		allBrowsers[0] = tabOne;
//		allBrowsers[1] = tabTwo;
//		allBrowsers[2] = tabThree;
//		allBrowsers[3] = tabFour;
//		allBrowsers[4] = tabFive;
		
//		System.out.println(GoogleChrome.getNumberOfChromeTabs());
//		System.out.println(Firefox.getNumberOfFirefoxTabs());
		
		// Finding the number of Tabs of Firefox and Chrome
//		int firefoxTabs = 0;
//		int chromeTabs = 0;
//
//		for (int i = 0; i < 5; ++i) {
//			if (allBrowsers[i] instanceof Firefox) {
//				firefoxTabs++;
//			} else {
//				chromeTabs++;
//			}
//		}
//
//		System.out.println("Number of firefox Tabs: " + firefoxTabs);
//		System.out.println("Number of Chrome Tabs: " + chromeTabs);
//
		/*
		 * AccessAllowed camera = AccessAllowed.CAMERA; AccessAllowed location =
		 * AccessAllowed.LOCATION; AccessAllowed microphone = AccessAllowed.MICROPHONE;
		 * 
		 * //Permission settings for Chrome
		 */
//		GoogleChrome.setPermission(true, false, false);
//		GoogleChrome.resetPermission();
//		GoogleChrome.setPermission(true, false, true);
//		GoogleChrome.resetPermission();
//		GoogleChrome.setPermission();
//
//		Firefox browserOfFirefox = (Firefox) tabTwo;
//		browserOfFirefox.addnewContainer("Messenger");
//		browserOfFirefox.addnewContainer("Mails");
//
//		browserOfFirefox.leavenewContainer("Messenger");
//		Browser chrome1 = new GoogleChrome();
//		Browser firefox1 = new Firefox();
//		chrome1.whoAmI();
//		firefox1.whoAmI();
//		Browser browser = new Browser();
//		browser.whoAmI();
		
		
		

	}
	public static void mainMenu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose Browser: ");
		System.out.println("1. Google Chrome: ");
		System.out.println("2. Firefox");
		System.out.println("3. Exit");
		System.out.print("Enter your Choice: ");
		int choice = scanner.nextInt();
		switch(choice){
			case 1: firefoxMenu();
					break;
			case 2: chromeMenu();
					break;
			case 3: System.out.println("Quitting...");
					System.exit(0);
					break;
			default: System.out.println("Wrong Choice");
		}
	}
	
	public static void firefoxMenu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Firefox Menu");
		System.out.println("-------------------");
		System.out.println("1. Create New Tab");
		System.out.println("2. Add Container");
		System.out.println("3. Leave Container");
		System.out.println("4. Get Number of Tabs");
		System.out.print("Enter your choice: ");
		int choice = scanner.nextInt();
		switch(choice) {
			case 1: System.out.print("Enter URL: ");
					firefoxTab.put(scanner.next(), new Firefox());
					break;
			case 2: addnewFirefoxContainer();
					break;
			case 3: leaveFirefoxContainer();
					break;
			case 4: System.out.println("Number of FirefoxTabs: " + Firefox.getNumberOfFirefoxTabs());
					break;
			default:System.out.println("Wrong Input!!!");
		}
	}
	
	public static void addnewFirefoxContainer() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter url: ");
		String url = scanner.next();
		System.out.println("Enter container: ");
		String container = scanner.next();
		firefoxTab.get(url).addnewContainer(container);				
	}
	
	public static void leaveFirefoxContainer() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter url: ");
		String url = scanner.next();
		System.out.println("Enter container: ");
		String container = scanner.next();
		firefoxTab.get(url).leaveContainer(container);				
	}
	
	public static void chromeMenu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Chrome Menu");
		System.out.println("---------------");
		System.out.println("1. Create New Tab");
		System.out.println("2. Set Browser Permission");
		System.out.println("3. Reset Browser Permission");
		System.out.println("4. Get Number of Tabs");
		System.out.println("Enter your Choice");
		int choice = scanner.nextInt();
		switch(choice) {
			case 1: System.out.println("Enter url: ");
			        chromeTab.put(scanner.next(), new GoogleChrome());
			        break;
			case 2: setChromePermission();
					break;
			case 3: GoogleChrome.resetPermission();
					break;
			case 4: System.out.println("Number of Chrome Tabs: " + GoogleChrome.getNumberOfChromeTabs());
					break;
			default:System.out.println("Wrong Input!!!");
			        
		}
	}
	public static void setChromePermission() {
		//camera, location, microphone
		Scanner scanner = new Scanner(System.in);
		boolean cameraAccess;
		boolean locationAccess;
		boolean microphoneAccess;
		System.out.print("Enter camera permission(y/n): ");
		if(scanner.next().charAt(0) == 'y') {
			cameraAccess = true;
		}
		else {
			cameraAccess = false;
		}
		System.out.print("Enter location permission(y/n): ");
		if(scanner.next().charAt(0) == 'y') {
			locationAccess = true;
		}
		else {
			locationAccess = false;
		}
		System.out.print("Enter microphone permission(y/n): ");
		if(scanner.next().charAt(0) == 'y') {
			microphoneAccess = true;
		}
		else {
			microphoneAccess = false;
		}
		GoogleChrome.setPermission(cameraAccess, locationAccess, microphoneAccess);
	}
}
