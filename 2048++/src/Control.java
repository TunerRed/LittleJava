/**类似于监听器的作用，Start和Game2048使用这个类中的属性进行某些活动，而不是直接在许多组件中添加许多监听
 * 本类中有上下左右、z、enter，六个键，分别对应方向控制，确认和进入
 */

public class Control {
	public static boolean
		UP = false,
		DOWN = false,
		LEFT = false,
		RIGHT = false,
	    ENTER=false,
		BACKSPACE = false,
		SPACE = false;
}
