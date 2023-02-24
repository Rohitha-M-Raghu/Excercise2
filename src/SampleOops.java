import java.util.HashSet;

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

	public void leavenewContainer(String remContainer);
}

//Chrome
class GoogleChrome extends Browser {
	private final String versionNumber = "1.0";
	private static boolean isLocationAccessible;
	private static boolean isCameraAccessible;
	private static boolean isMicrophoneAccessible;

	GoogleChrome() {
		super();
	}

	@Override
	public void whoAmI() {
		System.out.println("I am GoogleChrome");
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

	Firefox() {
		super();
//		System.out.println("Firefox Object Created... ");
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
	public void leavenewContainer(String remContainer) {
		// leave newContainer
		if (!containers.contains(remContainer)) {
			System.out.println(remContainer + " doesn't exist inside the container");
		} else {
			containers.remove(remContainer);
		}
	}
}

public class SampleOops {
	public static void main(String[] args) {
//		
		Browser tabOne = new GoogleChrome();
		Browser tabTwo = new Firefox();
		Browser tabThree = new Firefox();
		Browser tabFour = new GoogleChrome();
		Browser tabFive = new GoogleChrome();
		Browser[] allBrowsers = new Browser[5];
		allBrowsers[0] = tabOne;
		allBrowsers[1] = tabTwo;
		allBrowsers[2] = tabThree;
		allBrowsers[3] = tabFour;
		allBrowsers[4] = tabFive;
		// Finding the number of Tabs of Firefox and Chrome
		int firefoxTabs = 0;
		int chromeTabs = 0;

		for (int i = 0; i < 5; ++i) {
			if (allBrowsers[i] instanceof Firefox) {
				firefoxTabs++;
			} else {
				chromeTabs++;
			}
		}

		System.out.println("Number of firefox Tabs: " + firefoxTabs);
		System.out.println("Number of Chrome Tabs: " + chromeTabs);

		/*
		 * AccessAllowed camera = AccessAllowed.CAMERA; AccessAllowed location =
		 * AccessAllowed.LOCATION; AccessAllowed microphone = AccessAllowed.MICROPHONE;
		 * 
		 * //Permission settings for Chrome
		 */
		GoogleChrome.setPermission(true, false, false);
		GoogleChrome.resetPermission();
		GoogleChrome.setPermission(true, false, true);
		GoogleChrome.resetPermission();
		GoogleChrome.setPermission();

		Firefox browserOfFirefox = (Firefox) tabTwo;
		browserOfFirefox.addnewContainer("Messenger");
		browserOfFirefox.addnewContainer("Mails");

		browserOfFirefox.leavenewContainer("Messenger");
		Browser chrome1 = new GoogleChrome();
		Browser firefox1 = new Firefox();
		chrome1.whoAmI();
		firefox1.whoAmI();
		Browser browser = new Browser();
		browser.whoAmI();

	}
}
