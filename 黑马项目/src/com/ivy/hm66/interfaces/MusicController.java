package com.ivy.hm66.interfaces;

public interface MusicController {
	void play();
	void stop();
	void pause();
	void playNetMusic(String path);
	void seek(int progress);
}
