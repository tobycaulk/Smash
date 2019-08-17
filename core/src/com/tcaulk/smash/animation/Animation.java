package com.tcaulk.smash.animation;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Animation {
    private static final int MAX_FRAME_TICKS = 5;

    private Texture texture;
    private AnimationFrame[] frames;
    private int currentFrameIndex = 0;
    private int currentFrameTicks = 0;

    public Animation(Texture texture, AnimationFrame[] frames) {
        this.texture = texture;
        this.frames = frames;
    }

    public TextureRegion getCurrentFrame() {
        if(currentFrameTicks == MAX_FRAME_TICKS) {
            currentFrameTicks = 0;
            currentFrameIndex++;
        }

        if(currentFrameIndex == frames.length) {
            currentFrameIndex = 0;
        }

        currentFrameIndex++;
        AnimationFrame currentFrame = frames[currentFrameIndex];

        return new TextureRegion(texture, currentFrame.x, currentFrame.y, currentFrame.width, currentFrame.height);
    }

    public static AnimationFrame[] getAnimationFrameRange(int startX, int startY, int frameWidth, int frameHeight, int frameCount) {
        AnimationFrame[] frames = new AnimationFrame[frameCount];

        for(int i = 0; i < frameCount; i++) {
            frames[i] = new AnimationFrame((i * frameWidth) + startX, startY, frameWidth, frameHeight);
        }

        return frames;
    }
}