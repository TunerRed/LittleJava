package musicThread;

import java.io.InputStream;

import sun.audio.AudioPlayer;

public class Music {
	private static InputStream in1;
	private static InputStream in2;
	private static InputStream in3;
	private static InputStream in4;
	private static InputStream in5;
	private static InputStream in6;
	private static InputStream in7;
	private static InputStream in8;
	private static InputStream in9;

	public static void run1() {
		in1 = Music.class.getClassLoader().getResourceAsStream("button.wav");
		AudioPlayer.player.start(in1);
	}
	public static void run2() {
		in2 = Music.class.getClassLoader().getResourceAsStream(
				"enemy0_down.wav");
		AudioPlayer.player.start(in2);
	}

	public static void run3() {
		in3 = Music.class.getClassLoader().getResourceAsStream(
				"enemy1_down.wav");
		AudioPlayer.player.start(in3);

	}

	public static void run4() {
		in4 = Music.class.getClassLoader().getResourceAsStream(
				"enemy2_down.wav");
		AudioPlayer.player.start(in4);
	}

	public static void run5() {
		in5 = Music.class.getClassLoader().getResourceAsStream("button.wav");
		AudioPlayer.player.start(in5);
	}

	public static void run6() {
		in6 = Music.class.getClassLoader()
				.getResourceAsStream("get_bullet.wav");
		AudioPlayer.player.start(in6);

	}

	public static void run7() {
		in7 = Music.class.getClassLoader().getResourceAsStream("get_bomb.wav");
		AudioPlayer.player.start(in7);
	}

	public static void run8() {
		in8 = Music.class.getClassLoader().getResourceAsStream("use_bomb.wav");
		AudioPlayer.player.start(in8);
	}

	public static void run9() {
		in2 = Music.class.getClassLoader().getResourceAsStream("bgm.wav");
			AudioPlayer.player.start(in2);
	}

}
