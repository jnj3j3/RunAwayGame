package ObjectManagement;

import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import CharacterState.CharacterState;
import GameState.GameState;
import	Source.Animation;
import Source.Resource;

public class Character { //메인 캐릭터에 대한 것들을 저장
	public static final int landposition = 80;
	public static final float gravity = 0.4f;
	
	private float posY;
	private float posX;
	private float speedX;
	private float speedY;
	private Rectangle nowRange;
	
	private boolean isPlayed;
	
	public int score = 0;
	public int highestScore =0;
	
	CharacterState characterState = new CharacterState();
	
	private Animation runningAni;
	private Animation jumpingAni;
	private BufferedImage Camouflage;
	private BufferedImage deathImage;
	
	private AudioClip jumpSound;
	private AudioClip deadSound;
	private AudioClip scoreUpSound;
	private AudioClip newRecordSound;
	
	private ArrayList<BufferedImage> image = new ArrayList<>();
	
	public Character() {
		posX = 50;
		posY = landposition;
		isPlayed= false;
		nowRange = new Rectangle();
		runningAni = new Animation(70);
		runningAni.addFrame(Resource.getResouceImage("data/run1.png"));
		runningAni.addFrame(Resource.getResouceImage("data/run2.png"));
		runningAni.addFrame(Resource.getResouceImage("data/run3.png"));
		runningAni.addFrame(Resource.getResouceImage("data/run4.png"));
		runningAni.addFrame(Resource.getResouceImage("data/run5.png"));
		runningAni.addFrame(Resource.getResouceImage("data/run6.png"));
		jumpingAni = new Animation(80);
		jumpingAni.addFrame(Resource.getResouceImage("data/jump1.png"));
		jumpingAni.addFrame(Resource.getResouceImage("data/jump2.png"));

		
		jumpingAni.addFrame(Resource.getResouceImage("data/jump5.png"));
		jumpingAni.addFrame(Resource.getResouceImage("data/jump6.png"));
		jumpingAni.addFrame(Resource.getResouceImage("data/jump7.png"));
		
		Camouflage=Resource.getResouceImage("data/box.png");
		
		deathImage=Resource.getResouceImage("data/dead.png");
		
		
		
		try {
			jumpSound =  Applet.newAudioClip(new URL("file","","data/jump.wav"));
			deadSound =  Applet.newAudioClip(new URL("file","","data/MP_failure.wav"));
			scoreUpSound =  Applet.newAudioClip(new URL("file","","data/MP_Pling.wav"));  //사운드 모음
			newRecordSound = Applet.newAudioClip(new URL("file","","data/MP_Winning-Triumphal-Fanfare.wav"));
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public float getSpeedX() {
		return speedX;
	}

	public void setSpeedX(float speedX) {
		this.speedX = speedX;
	}
	
	public void draw(Graphics g) {
		image.add(runningAni.getFrame());
		image.add(jumpingAni.getFrame());
		image.add(Camouflage);
		image.add(deathImage);
		characterState.draw(g, image, (int)posX, (int)posY);
		image = new ArrayList<BufferedImage>();

	}
	
	public void update() {
		runningAni.updateFrame();
		jumpingAni.updateFrame();
		if(posY >= landposition) {
			posY = landposition;
			characterState.setRun();
		} else {
			speedY += gravity;
			posY += speedY;
		}
	}
	
	public void jump() {
		if(posY >= landposition) {
			if(jumpSound != null) {
				jumpSound.play();
			}
			speedY = -7.5f;
			posY += speedY;
			characterState.setState(characterState.getJumpingState());
		}
	}
	
	public void down(boolean isDown) {
		characterState.down(isDown);
	}
	
	public Rectangle getRange() {
		nowRange = new Rectangle();
		image.add(runningAni.getFrame());
		image.add(Camouflage);
		characterState.range(nowRange, image, (int)posX, (int)posY);
		image = new ArrayList<>();
		return nowRange;
	}
	
	public void dead(boolean isDeath) {
		if(isDeath) {
			characterState.setState(characterState.getDeathState());
	
		} else {
			characterState.setState(characterState.getRunState());
	
		}
	}
	
	public void reset() {
		posY = landposition;
		isPlayed = false;
	}
	
	public void playDeadSound() {
		deadSound.play();
	}
	
	public void upScore() {
		score += 20;
		if(score % 100 == 0) {
			scoreUpSound.play();
		}
		if(highestScore<score&&!isPlayed) {
			newRecordSound.play();
			isPlayed = true;
		}
	}
	
}