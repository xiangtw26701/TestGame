package com.xiangouo.mc.game.tasks;

import com.ericlam.mc.minigames.core.SectionTask;
import com.ericlam.mc.minigames.core.manager.PlayerManager;

public class EndSectionTask implements SectionTask {
    @Override
    public void initTimer(PlayerManager playerManager) {

    }

    @Override
    public void onCancel() {

    }

    @Override
    public void onFinish() {

    }

    @Override
    public long run(long l) {
        return 0;
    }

    @Override
    public long getTotalTime() {
        return 0;
    }

    @Override
    public boolean shouldCancel() {
        return false;
    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public void setRunning(boolean b) {

    }
}
