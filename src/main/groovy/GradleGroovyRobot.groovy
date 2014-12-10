import org.robovm.apple.foundation.NSAutoreleasePool
import org.robovm.apple.foundation.NSDictionary
import org.robovm.apple.foundation.NSString
import org.robovm.apple.foundation.Foundation
import org.robovm.apple.uikit.UIApplication
import org.robovm.apple.uikit.UIApplicationDelegateAdapter
import org.robovm.apple.uikit.UIButton
import org.robovm.apple.uikit.UIButtonType
import org.robovm.apple.uikit.UIControlState
import org.robovm.apple.uikit.UIWindow
import org.robovm.objc.annotation.NotImplemented
import org.robovm.apple.uikit.UIControl
import org.robovm.apple.uikit.UIEvent
import org.robovm.apple.uikit.UIScreen
import org.robovm.apple.uikit.UIColor
import org.robovm.apple.uikit.UIApplicationLaunchOptions
import org.robovm.apple.coregraphics.CGRect
import groovy.transform.CompileStatic

@CompileStatic
class GradleGroovyRobot extends UIApplicationDelegateAdapter {
	
	UIWindow window = null
	UIButton button = null
	int clickCount = 0
	
	
	@Override
	boolean didFinishLaunching(UIApplication application,
			UIApplicationLaunchOptions launchOptions) {
        Foundation.log 'didFinishLaunching'
		button = UIButton.create(UIButtonType.RoundedRect)
		button.frame = new CGRect(80.0f, 121.0f, 180.0f, 37.0f)
		button.setTitle('iOS, Groovy is in you!', UIControlState.Normal)
		
		window = new UIWindow(UIScreen.mainScreen.bounds)
		window.backgroundColor = UIColor.lightGray()
		window.addSubview(button)
		window.makeKeyAndVisible()
		return true
	}
			
	@CompileStatic
	static void main(String[] args) {
		System.out.println 'Squak'
		def pool = new NSAutoreleasePool()
		UIApplication.main(args, GradleGroovyRobotApplication.class, GradleGroovyRobot.class)
		pool.close()
	}
}
